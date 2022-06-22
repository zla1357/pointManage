package com.triple.point.service;

import com.triple.point.domain.Point;

public interface PointService {
    Long registerPoint(Point point);
    Point getPoint(Long id);
    Point getPointByUserId(String userId);
}
