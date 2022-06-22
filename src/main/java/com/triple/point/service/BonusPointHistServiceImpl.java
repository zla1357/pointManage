package com.triple.point.service;

import com.triple.point.domain.BonusPointHist;
import com.triple.point.repository.BonusPointHistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BonusPointHistServiceImpl implements BonusPointHistService {

    private final BonusPointHistRepository bonusPointHistRepository;

    @Transactional
    @Override
    public Long registerBonusPointHist(BonusPointHist bonusPointHist) {
        bonusPointHistRepository.registerBonusPointHist(bonusPointHist);

        return bonusPointHist.getId();
    }

    @Override
    public BonusPointHist getBonusPointHist(Long id) {
        return bonusPointHistRepository.getBonusPointHist(id);
    }

    @Override
    public BonusPointHist getRecentBonusPointHist(String placeId) {
        return bonusPointHistRepository.getRecentBonusPointHist(placeId);
    }
}
