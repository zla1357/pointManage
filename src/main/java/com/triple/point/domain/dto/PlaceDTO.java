package com.triple.point.domain.dto;

import com.triple.point.domain.ModelMapperUtils;
import com.triple.point.domain.Place;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@NoArgsConstructor
@Setter
public class PlaceDTO {

    private UUID id;
    private String name;

    public PlaceDTO(String name) {
        this.name = name;
    }

    public Place mapToEntity() {
        return Place.createPlace(this.name);
    }

    public static PlaceDTO from(Place place) {
        return ModelMapperUtils.getModelMapper().map(place, PlaceDTO.class);
    }
}
