package com.triple.point.domain.dto;

import lombok.Getter;

@Getter
public class CalcPointDTO {

    private String reviewId;
    private String content;
    private String[] attachedPhotoIds;

    public CalcPointDTO(EventDTO eventDTO){
        this.reviewId = eventDTO.getReviewId();
        this.content = eventDTO.getContent();
        this.attachedPhotoIds = eventDTO.getAttachedPhotoIds();
    }
}
