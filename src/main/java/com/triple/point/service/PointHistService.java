package com.triple.point.service;

import com.triple.point.domain.PointHist;

public interface PointHistService {
    Long registerPointHist(PointHist pointHist);
    PointHist getPointHist(Long id);
    PointHist getRecentPointHist(String userId, String reviewId);
}
