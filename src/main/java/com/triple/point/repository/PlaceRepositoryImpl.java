package com.triple.point.repository;

import com.triple.point.domain.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PlaceRepositoryImpl implements PlaceRepository{

    private final EntityManager em;

    @Override
    public void registryPlace(Place place) {
        em.persist(place);
    }

    @Override
    public Place getPlace(UUID placeId) {
        return em.find(Place.class, placeId);
    }
}
