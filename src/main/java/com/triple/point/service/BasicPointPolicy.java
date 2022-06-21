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

        return contentPoint(calcPointDTO.getContent())
                + photoPoint(calcPointDTO.getAttachedPhotoIds());
        // TODO 보너스 점수 루틴 수정 후 보너스 점수 부여해야함
                //+ bonusPoint(calcPointDTO.getPlaceId());
    }

    private int contentPoint(String content) {
        return content.length() > 0 ? 1 : 0;
    }

    private int photoPoint(String[] attachedPhotoIds) {
        return attachedPhotoIds.length > 0 ? 1 : 0;
    }

    // 해당 장소에서 작성된 리뷰가 없으면 보너스 점수 부여
    private int bonusPoint(String placeId) {
        // TODO 보너스 점수 부여 루틴 수정해야함
        List<String> reviewsInPlace = pointService.reviewsInPlace(placeId);
        return reviewsInPlace.size() > 0 ? 0 : 1;
    }
}
