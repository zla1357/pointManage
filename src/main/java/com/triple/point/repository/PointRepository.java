package com.triple.point.repository;

import com.triple.point.domain.Point;

public interface PointRepository {
    public void registerPoint(Point point);
    public Point getPoint(Long id);
}
