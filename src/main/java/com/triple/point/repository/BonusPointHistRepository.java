package com.triple.point.repository;

import com.triple.point.domain.BonusPointHist;

public interface BonusPointHistRepository {
    public void registryBonusPointHist(BonusPointHist bonusPointHist);
    public BonusPointHist getBonusPointHist(Long id);
}
