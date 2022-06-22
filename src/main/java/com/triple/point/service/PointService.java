package com.triple.point.service;

import com.triple.point.domain.Point;

public interface PointService {
    public Long registerPoint(Point point);
    public Point getPoint(Long id);
}
