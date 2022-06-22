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
}
