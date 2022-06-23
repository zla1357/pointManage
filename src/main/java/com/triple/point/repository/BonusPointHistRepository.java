package com.triple.point.repository;

import com.triple.point.domain.BonusPointHist;

public interface BonusPointHistRepository {
    void registerBonusPointHist(BonusPointHist bonusPointHist);
    BonusPointHist getBonusPointHist(Long id);
    BonusPointHist getRecentBonusPointHist(String placeId);
    BonusPointHist getRecentUserBonusHist(String userId, String placeId);
}
