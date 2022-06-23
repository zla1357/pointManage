package com.triple.point.service;

import com.triple.point.domain.Action;
import com.triple.point.domain.BonusPointHist;
import com.triple.point.domain.Point;
import com.triple.point.domain.PointHist;
import com.triple.point.domain.dto.CalcPointDTO;
import com.triple.point.domain.dto.EventDTO;
import com.triple.point.domain.dto.ReviewPointDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final PointService pointService;
    private final PointHistService pointHistService;
    private final BonusPointHistService bonusPointHistService;
    private final PointPolicy pointPolicy;

    @Override
    public void reviewEvent(EventDTO eventDTO) {

        CalcPointDTO calcPointDTO = new CalcPointDTO(eventDTO);

        // DELETE 추가
        // ADD시 포인트 계산 후 저장
        // MOD시 보너스 포인트는 저장할 필요 없음
        // DELETE시 Point에서 해당 리뷰의 점수 및 보너스 점수만큼 빼고
        // 모든 포인트 0, 보너스 포인트 0으로 저장
        if(Action.ADD.equals(eventDTO.getAction())) {
            addPoint(eventDTO, calcPointDTO);
        } else if(Action.MOD.equals(eventDTO.getAction())) {
            modifyPoint(eventDTO, calcPointDTO);
        } else if(Action.DELETE.equals(eventDTO.getAction())) {

        }
    }

    // 포인트 신규 저장
    private void addPoint(EventDTO eventDTO, CalcPointDTO calcPointDTO) {
        ReviewPointDTO pointDTO = pointPolicy.getPointDTO(calcPointDTO);
        int pointAmount = pointPolicy.calculatePoint(calcPointDTO);

        addBonusHistIfExist(eventDTO, pointDTO);
        addPointHist(eventDTO, pointDTO);
        registerUserPoint(eventDTO, pointAmount);
    }

    private void addBonusHistIfExist(EventDTO eventDTO, ReviewPointDTO reviewPointDTO) {
        if(isBonusExist(reviewPointDTO)) {
            BonusPointHist bonusPointHist = BonusPointHist.createBonusPointHist(eventDTO, reviewPointDTO.getBonusPoint());
            bonusPointHistService.registerBonusPointHist(bonusPointHist);
        }
    }

    private void addPointHist(EventDTO eventDTO, ReviewPointDTO pointDTO) {
        PointHist pointHist = PointHist.createPointHist(eventDTO.getUserId(),
                eventDTO.getReviewId(),
                pointDTO.getContentPoint(),
                pointDTO.getImagePoint());

        pointHistService.registerPointHist(pointHist);
    }

    private void registerUserPoint(EventDTO eventDTO, int pointAmount) {
        if(userHavePoint(eventDTO.getUserId())) {
            accumulatePoint(eventDTO, pointAmount);
        } else{
            pointService.registerPoint(new Point(eventDTO.getUserId(), pointAmount));
        }
    }

    private boolean userHavePoint(String userId) {

        Point userPoint = pointService.getPointByUserId(userId);

        return userPoint != null;
    }

    private boolean isBonusExist(ReviewPointDTO pointDTO) {
        return pointDTO.getBonusPoint() > 0;
    }

    // 기존 포인트 수정
    private void modifyPoint(EventDTO eventDTO, CalcPointDTO calcPointDTO) {
        int accPoint = calcAccumulatePoint(eventDTO, calcPointDTO);

        addPointHist(eventDTO, pointPolicy.getPointDTO(calcPointDTO));

        accumulatePoint(eventDTO, accPoint);;
    }

    private int calcAccumulatePoint(EventDTO eventDTO, CalcPointDTO calcPointDTO) {
        PointHist recentPointHist = pointHistService.getRecentPointHist(eventDTO.getUserId(), eventDTO.getReviewId());

        return pointPolicy.calculatePoint(calcPointDTO) - (recentPointHist.getContentPoint() + recentPointHist.getImagePoint());
    }

    private void accumulatePoint(EventDTO eventDTO, int pointAmount) {

        Point point = pointService.getPointByUserId(eventDTO.getUserId());
        point.accumulatePoint(pointAmount);
        pointService.registerPoint(point);
    }
}
