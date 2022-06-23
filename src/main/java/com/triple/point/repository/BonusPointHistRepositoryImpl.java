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
    public void registerBonusPointHist(BonusPointHist bonusPointHist) {
        em.persist(bonusPointHist);
    }

    @Override
    public BonusPointHist getBonusPointHist(Long id) {
        return em.find(BonusPointHist.class, id);
    }

    @Override
    public BonusPointHist getRecentBonusPointHist(String placeId) {
        return em.createQuery(
                "select h " +
                        "from BonusPointHist h " +
                        "where h.placeId = :placeId " +
                        "order by h.inputDate desc", BonusPointHist.class)
                .setParameter("placeId", placeId)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public BonusPointHist getRecentUserBonusHist(String userId, String placeId) {
        return em.createQuery(
                "select h " +
                        "from BonusPointHist h " +
                        "where h.placeId = :placeId " +
                        "and h.userId = :userId " +
                        "order by h.inputDate desc ", BonusPointHist.class)
                .setParameter("placeId", placeId)
                .setParameter("userId", userId)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }
}
