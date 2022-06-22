package com.triple.point.service;

import com.triple.point.domain.BonusPointHist;

public interface BonusPointHistService {
    Long registerBonusPointHist(BonusPointHist bonusPointHist);
    BonusPointHist getBonusPointHist(Long id);
    BonusPointHist getRecentBonusPointHist(String placeId);
}
