package com.triple.point.controller;

import com.triple.point.domain.dto.PlaceDTO;

public interface PlaceController {

    public String registryPlace(String name);
    public PlaceDTO getPlace(String placeId);
}
