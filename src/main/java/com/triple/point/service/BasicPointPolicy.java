package com.triple.point.service;

import com.triple.point.domain.dto.CalcPointDTO;

public class BasicPointPolicy implements PointPolicy {
    @Override
    public int calculatePoint(CalcPointDTO calcPointDTO) {
        return 0;
    }
}
