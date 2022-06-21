package com.triple.point.service;

import com.triple.point.domain.dto.CalcPointDTO;
import com.triple.point.domain.dto.ReviewPointDTO;

public interface PointPolicy {
    int calculatePoint(CalcPointDTO calcPointDTO);
    ReviewPointDTO getPointDTO(CalcPointDTO calcPointDTO);
}
