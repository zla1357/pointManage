package com.triple.point.service;

import com.triple.point.domain.PointHist;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PointHistServiceImplTest {

    @Autowired
    private PointHistService pointHistService;

    @Test
    public void 포인트내역_저장() throws Exception {
        // given
        PointHist pointHist = PointHist.createPointHist(UUID.randomUUID().toString(), UUID.randomUUID().toString(), 1, 1);

        // when
        Long saveHistId = pointHistService.registerPointHist(pointHist);
        PointHist saveHist = pointHistService.getPointHist(saveHistId);

        // then
        Assertions.assertThat(pointHist).isEqualTo(saveHist);
    }

    @Test
    public void 최근_포인트내역_조회() throws Exception {
        // given
        String userId1 = UUID.randomUUID().toString();
        String reviewId1 = UUID.randomUUID().toString();

        PointHist pointHist1 = PointHist.createPointHist(userId1, reviewId1, 1, 1);
        pointHistService.registerPointHist(pointHist1);

        PointHist pointHist2 = PointHist.createPointHist(userId1, reviewId1, 1, 0);
        pointHistService.registerPointHist(pointHist2);

        PointHist pointHist3 = PointHist.createPointHist(userId1, reviewId1, 0, 1);
        pointHistService.registerPointHist(pointHist3);

        // when
        PointHist recentPointHist = pointHistService.getRecentPointHist(userId1, reviewId1);
        // then
        Assertions.assertThat(recentPointHist.equals(pointHist3)).isEqualTo(true);
    }
}