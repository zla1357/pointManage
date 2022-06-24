package com.triple.point.service;

import com.triple.point.domain.BonusPointHist;
import com.triple.point.domain.dto.CalcPointDTO;
import com.triple.point.domain.dto.ReviewPointDTO;
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
                + newPlaceBonusPoint(calcPointDTO.getPlaceId());
    }

    @Override
    public ReviewPointDTO getPointDTO(CalcPointDTO calcPointDTO) {
        return new ReviewPointDTO(contentPoint(calcPointDTO.getContent()),
                photoPoint(calcPointDTO.getAttachedPhotoIds()),
                newPlaceBonusPoint(calcPointDTO.getPlaceId()));
    }

    private int contentPoint(String content) {
        return content.length() > 0 ? 1 : 0;
    }

    private int photoPoint(String[] attachedPhotoIds) {
        return (attachedPhotoIds != null && attachedPhotoIds.length > 0) ? 1 : 0;
    }

    // 해당 장소에서 작성된 리뷰가 있는지에 따라 보너스 점수 반환
    private int newPlaceBonusPoint(String placeId) {
        BonusPointHist reviewsInPlace = bonusPointHistService.getRecentBonusPointHist(placeId);

        if(reviewsInPlace == null) {
            return 1;
        } else {
            return reviewsInPlace.getPlacePoint() > 0 ? 0 : 1;
        }
    }
}
