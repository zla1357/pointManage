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

        // TODO MOD와 DELETE 추가
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

    private void addPoint(EventDTO eventDTO, CalcPointDTO calcPointDTO) {
        int pointAmount = pointPolicy.calculatePoint(calcPointDTO);

        ReviewPointDTO pointDTO = pointPolicy.getPointDTO(calcPointDTO);
        if(pointDTO.getBonusPoint() > 0) {
            addBonusPointHist(eventDTO, pointDTO);
        }

        addPointHist(eventDTO, pointDTO);
        pointService.registerPoint(new Point(eventDTO.getUserId(), pointAmount));
    }

    private void addBonusPointHist(EventDTO eventDTO, ReviewPointDTO reviewPointDTO) {
        BonusPointHist bonusPointHist = BonusPointHist.createBonusPointHist(eventDTO, reviewPointDTO.getBonusPoint());
        bonusPointHistService.registerBonusPointHist(bonusPointHist);
    }

    private void addPointHist(EventDTO eventDTO, ReviewPointDTO pointDTO) {
        PointHist pointHist = PointHist.createPointHist(eventDTO.getUserId(),
                eventDTO.getReviewId(),
                pointDTO.getContentPoint(),
                pointDTO.getImagePoint());

        pointHistService.registerPointHist(pointHist);
    }

    private void modifyPoint(EventDTO eventDTO, CalcPointDTO calcPointDTO) {
        calcModifyPoint(calcPointDTO);

        //포인트 내역 저장

        accumulatePoint();;
    }

    // 최근 포인트 내역과 저장할 포인트를 비교하여 증감량 계산
    private void calcModifyPoint(CalcPointDTO calcPointDTO) {
        //가장 최근 포인트 내역 조회


        //파라미터로 넘어온 포인트와 비교하여 증감량 계산
    }

    private void accumulatePoint() {
        //포인트 조회
        //포인트 수정
        //포인트 저장
    }
}
