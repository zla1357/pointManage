package com.triple.point.service;

import com.triple.point.domain.Action;
import com.triple.point.domain.BonusPointHist;
import com.triple.point.domain.Point;
import com.triple.point.domain.dto.CalcPointDTO;
import com.triple.point.domain.dto.EventDTO;
import com.triple.point.domain.dto.ReviewPointDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final PointService pointService;

    private final PointPolicy pointPolicy;

    @Override
    public void reviewEvent(EventDTO eventDTO) {

        CalcPointDTO calcPointDTO = new CalcPointDTO(eventDTO);
        int pointAmount = pointPolicy.calculatePoint(calcPointDTO);

        // TODO Point 엔티티 저장시 PointHist와 BonusPointHist를 같이 저장하게 해야함
        // ADD시 포인트 계산 후 저장
        // MOD시 보너스 포인트는 저장할 필요 없음
        // DELETE시 Point에서 해당 리뷰의 점수 및 보너스 점수만큼 빼고
        // 모든 포인트 0, 보너스 포인트 0으로 저장
        if(Action.ADD.equals(eventDTO.getAction())) {

            addPoint(eventDTO, calcPointDTO, pointAmount);
        } else if(Action.MOD.equals(eventDTO.getAction())) {

        } else if(Action.DELETE.equals(eventDTO.getAction())) {

        }
    }

    // TODO PointHist 저장구문 추가해야함
    private void addPoint(EventDTO eventDTO, CalcPointDTO calcPointDTO, int pointAmount) {

        ReviewPointDTO pointDTO = pointPolicy.getPointDTO(calcPointDTO);
        if(pointDTO.getBonusPoint() > 0) {
            addBonusPointHist(eventDTO, pointDTO);
        }
        pointService.registerPoint(new Point(eventDTO.getUserId(), pointAmount));
    }

    private void addBonusPointHist(EventDTO eventDTO, ReviewPointDTO reviewPointDTO) {
        BonusPointHist.createBonusPointHist(eventDTO, reviewPointDTO.getBonusPoint());
    }
}
