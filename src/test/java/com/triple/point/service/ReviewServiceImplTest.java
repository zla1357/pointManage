package com.triple.point.service;

import com.triple.point.domain.Place;
import com.triple.point.domain.Review;
import com.triple.point.domain.User;
import com.triple.point.repository.ReviewRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ReviewServiceImplTest {

    @Autowired
    ReviewService reviewService;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    UserService userService;
    @Autowired
    PlaceService placeService;

    @Test
    public void 리뷰_저장() throws Exception {
        // given
        User khj = User.createUser("khj");
        UUID userId = userService.registryUser(khj);

        Place place1 = Place.createPlace("place1");
        UUID placeId = placeService.registryPlace(place1);

        Review review = Review.createReview(khj, place1);

        // when
        UUID reviewId = reviewService.registryReview(review);
        Review saveReview = reviewService.getReview(reviewId);

        // then
        Assertions.assertThat(review).isEqualTo(saveReview);
    }
}