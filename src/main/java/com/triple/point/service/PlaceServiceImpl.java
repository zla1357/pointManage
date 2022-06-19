package com.triple.point.service;

import com.triple.point.domain.Place;
import com.triple.point.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlaceServiceImpl implements PlaceService{

    private final PlaceRepository placeRepository;

    @Transactional
    @Override
    public UUID registryPlace(Place place) {
        placeRepository.registryPlace(place);

        return place.getId();
    }

    @Override
    public Place getPlace(UUID placeId) {
        return placeRepository.getPlace(placeId);
    }
}
