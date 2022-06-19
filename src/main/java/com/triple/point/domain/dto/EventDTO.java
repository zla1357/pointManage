package com.triple.point.domain.dto;

import com.triple.point.domain.Action;
import lombok.Getter;

@Getter
public class EventDTO {
    private String type;
    private Action action;
    private String reviewId;
    private String content;
    private String[] attachedPhotoIds;
    private String userId;
    private String placeId;
}
