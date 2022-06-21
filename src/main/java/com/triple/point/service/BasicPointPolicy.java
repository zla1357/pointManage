package com.triple.point.service;

import com.triple.point.domain.BonusPointHist;
import com.triple.point.domain.dto.CalcPointDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BasicPointPolicy implements PointPolicy {

    private final BonusPointHistService bonusPointHistService;

    @Override
    public int calculatePoint(CalcPointDTO calcPointDTO) {

        return contentPoint(calcPointDTO.getContent())
                + photoPoint(calcPointDTO.getAttachedPhotoIds())
                + bonusPoint(calcPointDTO.getPlaceId());
    }

    private int contentPoint(String content) {
        return content.length() > 0 ? 1 : 0;
    }

    private int photoPoint(String[] attachedPhotoIds) {
        return attachedPhotoIds.length > 0 ? 1 : 0;
    }

    // 해당 장소에서 작성된 리뷰가 없으면 보너스 점수 부여
    private int bonusPoint(String placeId) {
        BonusPointHist reviewsInPlace = bonusPointHistService.getRecentBonusPointHist(placeId);

        if(reviewsInPlace == null) {
            return 1;
        } else {
            return reviewsInPlace.getPlacePoint() > 0 ? 0 : 1;
        }
    }
}
