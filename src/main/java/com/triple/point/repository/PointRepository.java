package com.triple.point.repository;

import com.triple.point.domain.Point;

public interface PointRepository {
    void registerPoint(Point point);
    Point getPoint(Long id);
    Point getPointByUserId(String userId);
}
