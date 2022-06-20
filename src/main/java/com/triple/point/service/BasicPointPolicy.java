package com.triple.point.service;

import com.triple.point.domain.Point;
import com.triple.point.domain.dto.CalcPointDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BasicPointPolicy implements PointPolicy {

    private final PointService pointService;

    @Override
    public int calculatePoint(CalcPointDTO calcPointDTO) {
        int result = 0;

        result += contentPoint(calcPointDTO.getContent());
        result += photoPoint(calcPointDTO.getAttachedPhotoIds());
        result += bonusPoint(calcPointDTO.getPlaceId());

        return result;
    }

    // 해당 장소에서 작성된 리뷰가 없으면 보너스 점수 부여
    private int bonusPoint(String placeId) {
        List<String> reviewsInPlace = pointService.reviewsInPlace(placeId);
        return reviewsInPlace.size() > 0 ? 0 : 1;
    }

    private int photoPoint(String[] attachedPhotoIds) {
        return attachedPhotoIds.length > 0 ? 1 : 0;
    }

    private int contentPoint(String content) {
        return content.length() > 0 ? 1 : 0;
    }
}
