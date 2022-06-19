package com.triple.point.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class CalcPointDTO {

    private final String content;
    private final String placeId;
    private final String[] attachedPhotoIds;

    public CalcPointDTO(EventDTO eventDTO){
        this.content = eventDTO.getContent();
        this.placeId = eventDTO.getPlaceId();
        this.attachedPhotoIds = eventDTO.getAttachedPhotoIds();
    }
}
