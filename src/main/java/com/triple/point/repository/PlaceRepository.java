package com.triple.point.repository;

import com.triple.point.domain.Place;

import java.util.UUID;

public interface PlaceRepository {

    public void registryPlace(Place place);
    public Place getPlace(UUID placeId);
}
