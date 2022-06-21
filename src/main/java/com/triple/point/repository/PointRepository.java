package com.triple.point.repository;

import com.triple.point.domain.Point;

import java.util.List;

public interface PointRepository {
    public void registryPoint(Point point);
    public Point getPoint(Long id);
}
