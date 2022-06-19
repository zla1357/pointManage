package com.triple.point.service;

import com.triple.point.domain.Place;

import java.util.UUID;

public interface PlaceService {
    public UUID registryPlace(Place place);
    public Place getPlace(UUID placeId);
}
