package com.triple.point.service;

import com.triple.point.domain.Action;
import com.triple.point.domain.Point;
import com.triple.point.domain.dto.CalcPointDTO;
import com.triple.point.domain.dto.EventDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.UUID;

@SpringBootTest
class BasicPointPolicyTest {

    @Autowired
    PointService pointService;

    @Test
    public void 포인트_계산_테스트() throws Exception {
        // given
        String[] imgList = {UUID.randomUUID().toString(), UUID.randomUUID().toString()};
        EventDTO eventDTO = new EventDTO("REVIEW", Action.ADD, null, "좋았다", imgList, null, UUID.randomUUID().toString());

        CalcPointDTO calcPointDTO = new CalcPointDTO(eventDTO);
        BasicPointPolicy basicPointPolicy = new BasicPointPolicy(pointService);

        // when
        int point = basicPointPolicy.calculatePoint(calcPointDTO);

        // then
        Assertions.assertThat(point).isEqualTo(3);
    }

    @Test
    public void 보너스점수_없음() throws Exception {
        // given
        Point pointEntity = new Point(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), null);
        pointService.registryPoint(pointEntity);

        String[] imgList = {UUID.randomUUID().toString(), UUID.randomUUID().toString()};
        EventDTO eventDTO = new EventDTO("REVIEW", Action.ADD, null, "좋았다", imgList, null, pointEntity.getPlaceId());

        CalcPointDTO calcPointDTO = new CalcPointDTO(eventDTO);
        BasicPointPolicy basicPointPolicy = new BasicPointPolicy(pointService);

        // when
        int point = basicPointPolicy.calculatePoint(calcPointDTO);

        // then
        Assertions.assertThat(point).isEqualTo(2);
    }
}