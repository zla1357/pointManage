package com.triple.point.repository;

import com.triple.point.domain.Point;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class PointRepositoryImpl implements PointRepository {

    private final EntityManager em;

    @Override
    public void registerPoint(Point point) {
        em.persist(point);
    }

    @Override
    public Point getPoint(Long id) {
        return em.find(Point.class, id);
    }

    @Override
    public Point getPointByUserId(String userId) {
        return em.createQuery(
                "select p " +
                        "from Point p " +
                        "where p.userId = :userId ", Point.class)
                .setParameter("userId", userId)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }
}
