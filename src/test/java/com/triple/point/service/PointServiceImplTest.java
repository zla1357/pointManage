package com.triple.point.service;

import com.triple.point.domain.Point;
import com.triple.point.repository.PointRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class PointServiceImplTest {

    @Autowired
    PointService pointService;
    @Autowired
    PointRepository pointRepository;

    @Test
    public void 포인트_저장() throws Exception {
        // given
        Point point = new Point("240a0658-dc5f-4878-9381-ebb7b2667772",
                "3ede0ef2-92b7-4817-a5f3-0c575361f745",
                "2e4baf1c-5acb-4efb-a1af-eddada31b00f",
                "e4d1a64e-a531-46de-88d0-ff0ed70c0bb8,afb0cef2-851d-4a50-bb07-9cc15cbdc332");

        // when
        Long savePointId = pointService.registryPoint(point);
        Point savePoint = pointService.getPoint(savePointId);

        // then
        Assertions.assertThat(point).isEqualTo(savePoint);
    }
}