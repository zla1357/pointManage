package com.triple.point.repository;

import com.triple.point.domain.BonusPointHist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class BonusPointHistRepositoryImpl implements BonusPointHistRepository {

    private final EntityManager em;

    @Override
    public void registryBonusPointHist(BonusPointHist bonusPointHist) {
        em.persist(bonusPointHist);
    }

    @Override
    public BonusPointHist getBonusPointHist(Long id) {
        return em.find(BonusPointHist.class, id);
    }
}
