package com.triple.point.service;

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
    }
}
