package com.triple.point.service;

import com.triple.point.domain.Point;
import com.triple.point.repository.PointRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@SpringBootTest
@Transactional
class PointServiceImplTest {

    @Autowired
    PointService pointService;

    @Test
    public void 포인트_저장() throws Exception {
        // given
        Point point = new Point(UUID.randomUUID().toString(), 0);

        // when
        Long savePointId = pointService.registryPoint(point);
        Point savePoint = pointService.getPoint(savePointId);

        // then
        Assertions.assertThat(point).isEqualTo(savePoint);
    }
}