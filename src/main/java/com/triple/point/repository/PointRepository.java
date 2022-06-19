package com.triple.point.repository;

import com.triple.point.domain.Point;

public interface PointRepository {
    public void registryPoint(Point point);
    public Point getPoint(Long id);
}
