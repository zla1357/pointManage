package com.triple.point.service;

import com.triple.point.domain.Point;
import com.triple.point.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PointServiceImpl implements PointService {

    private final PointRepository pointRepository;

    @Override
    @Transactional
    public Long registerPoint(Point point) {
        pointRepository.registerPoint(point);

        return point.getId();
    }

    @Override
    public Point getPoint(Long id) {
        return pointRepository.getPoint(id);
    }
}
