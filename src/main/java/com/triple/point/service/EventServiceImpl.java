package com.triple.point.service;

import com.triple.point.domain.Action;
import com.triple.point.domain.Point;
import com.triple.point.domain.dto.CalcPointDTO;
import com.triple.point.domain.dto.EventDTO;
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

        if(Action.ADD.equals(eventDTO.getAction())) {

            String imgList = String.join(",", eventDTO.getAttachedPhotoIds());
            Point point = new Point(eventDTO.getReviewId(), eventDTO.getUserId(), eventDTO.getPlaceId(), imgList);
            pointService.registryPoint(point);
        } else if(Action.MOD.equals(eventDTO.getAction())) {

        } else if(Action.DELETE.equals(eventDTO.getAction())) {

        }
    }
}
