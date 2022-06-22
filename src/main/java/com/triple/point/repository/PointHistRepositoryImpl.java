package com.triple.point.repository;

import com.triple.point.domain.PointHist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class PointHistRepositoryImpl implements PointHistRepository {

    private final EntityManager em;

    @Override
    public void registerPointHist(PointHist pointHist) {
        em.persist(pointHist);
    }

    @Override
    public PointHist getPointHist(Long id) {
        return em.find(PointHist.class, id);
    }

    @Override
    public PointHist getRecentPointHist(String userId, String reviewId) {
        return em.createQuery(
                "select h " +
                        "from PointHist h " +
                        "where userId = :userId " +
                        "and reviewId = :reviewId " +
                        "order by h.inputDate desc ",
                PointHist.class)
                .setParameter("userId", userId)
                .setParameter("reviewId", reviewId)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }

}
