package com.triple.point.repository;

import com.triple.point.domain.Point;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PointRepositoryImpl implements PointRepository {

    private final EntityManager em;

    @Override
    public void registryPoint(Point point) {
        em.persist(point);
    }

    @Override
    public Point getPoint(Long id) {
        return em.find(Point.class, id);
    }

    @Override
    public List<String> reviewsInPlace(String placeId) {
        return em.createQuery(
                "select p.reviewId " +
                        "from Point p " +
                        "where p.placeId = :placeId", String.class)
                .setParameter("placeId", placeId)
                .getResultList();
    }
}
