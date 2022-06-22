package com.triple.point.repository;

import com.triple.point.domain.PointHist;

public interface PointHistRepository {
    void registerPointHist(PointHist pointHist);
    PointHist getPointHist(Long id);
}
