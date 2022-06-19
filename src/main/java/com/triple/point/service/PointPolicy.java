package com.triple.point.service;

import com.triple.point.domain.dto.CalcPointDTO;

public interface PointPolicy {
    public int calculatePoint(CalcPointDTO calcPointDTO);
}
