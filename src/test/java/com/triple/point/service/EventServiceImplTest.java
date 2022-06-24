package com.triple.point.service;

import com.triple.point.domain.Action;
import com.triple.point.domain.BonusPointHist;
import com.triple.point.domain.PointHist;
import com.triple.point.domain.dto.EventDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class EventServiceImplTest {

    @Autowired
    private EventService eventService;
    @Autowired
    private PointHistService pointHistService;
    @Autowired
    private BonusPointHistService bonusPointHistService;

    @Test
    public void 리뷰이벤트_ADD() throws Exception {
        // given
        String[] imgList = {UUID.randomUUID().toString(), UUID.randomUUID().toString()};
        EventDTO eventDTO = new EventDTO("REVIEW",
                Action.ADD,
                UUID.randomUUID().toString(),
                "좋았다",
                imgList,
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString());

        // when
        eventService.reviewEvent(eventDTO);
        PointHist savePointHist = pointHistService.getRecentPointHist(eventDTO.getUserId(), eventDTO.getReviewId());
        BonusPointHist saveBonus = bonusPointHistService.getRecentUserBonusHist(eventDTO.getUserId(), eventDTO.getPlaceId());

        // then
        Assertions.assertThat(savePointHist.getContentPoint() + savePointHist.getContentPoint()).isEqualTo(2);
        Assertions.assertThat(saveBonus.getPlacePoint()).isEqualTo(1);
    }

    @Test
    public void 리뷰이벤트_MOD() throws Exception {
        // given
        String reviewId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();
        String placeId = UUID.randomUUID().toString();
        String[] imgList = {UUID.randomUUID().toString(), UUID.randomUUID().toString()};

        EventDTO eventDTO = new EventDTO("REVIEW",
                Action.ADD,
                reviewId,
                "좋았다",
                imgList,
                userId,
                placeId);
        eventService.reviewEvent(eventDTO);

        EventDTO modEventDTO = new EventDTO("REVIEW",
                Action.MOD,
                reviewId,
                "좋았다",
                null,
                userId,
                placeId);
        eventService.reviewEvent(modEventDTO);

        // when
        eventService.reviewEvent(modEventDTO);
        PointHist savePointHist = pointHistService.getRecentPointHist(modEventDTO.getUserId(), modEventDTO.getReviewId());
        BonusPointHist saveBonus = bonusPointHistService.getRecentUserBonusHist(modEventDTO.getUserId(), modEventDTO.getPlaceId());

        // then
        Assertions.assertThat(savePointHist.getContentPoint() + savePointHist.getImagePoint()).isEqualTo(1);
        Assertions.assertThat(saveBonus.getPlacePoint()).isEqualTo(1);
    }

    @Test
    public void 리뷰이벤트_DELETE() throws Exception {
        // given
        String reviewId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();
        String placeId = UUID.randomUUID().toString();
        String[] imgList = {UUID.randomUUID().toString(), UUID.randomUUID().toString()};

        EventDTO eventDTO = new EventDTO("REVIEW",
                Action.ADD,
                reviewId,
                "좋았다",
                imgList,
                userId,
                placeId);
        eventService.reviewEvent(eventDTO);

        EventDTO delEventDTO = new EventDTO("REVIEW",
                Action.DELETE,
                reviewId,
                "좋았다",
                imgList,
                userId,
                placeId);
        eventService.reviewEvent(delEventDTO);

        // when
        eventService.reviewEvent(delEventDTO);
        PointHist savePointHist = pointHistService.getRecentPointHist(delEventDTO.getUserId(), delEventDTO.getReviewId());
        BonusPointHist saveBonus = bonusPointHistService.getRecentUserBonusHist(delEventDTO.getUserId(), delEventDTO.getPlaceId());

        // then
        Assertions.assertThat(savePointHist.getContentPoint() + savePointHist.getImagePoint()).isEqualTo(0);
        Assertions.assertThat(saveBonus.getPlacePoint()).isEqualTo(0);
    }
}