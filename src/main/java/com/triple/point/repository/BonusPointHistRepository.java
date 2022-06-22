package com.triple.point.repository;

import com.triple.point.domain.BonusPointHist;

public interface BonusPointHistRepository {
    public void registerBonusPointHist(BonusPointHist bonusPointHist);
    public BonusPointHist getBonusPointHist(Long id);
    public BonusPointHist getRecentBonusPointHist(String placeId);
}
