package com.triple.point.repository;

import com.triple.point.domain.Point;
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
}
