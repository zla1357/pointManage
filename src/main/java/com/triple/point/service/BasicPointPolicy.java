package com.triple.point.service;

import com.triple.point.domain.dto.CalcPointDTO;

public class BasicPointPolicy implements PointPolicy {
    @Override
    public int calculatePoint(CalcPointDTO calcPointDTO) {
        int result = 0;

        result += contentPoint(calcPointDTO.getContent());
        result += photoPoint(calcPointDTO.getAttachedPhotoIds());
        result += bonusPoint(calcPointDTO.getPlaceId());

        return result;
    }

    private int bonusPoint(String placeId) {
        // TODO 보너스 포인트 계산
        return 0;
    }

    private int photoPoint(String[] attachedPhotoIds) {
        return attachedPhotoIds.length > 0 ? 1 : 0;
    }

    private int contentPoint(String content) {
        return content.length() > 0 ? 1 : 0;
    }
}
