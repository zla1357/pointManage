package com.triple.point.service;

import com.triple.point.domain.Action;
import com.triple.point.domain.BonusPointHist;
import com.triple.point.domain.dto.EventDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@SpringBootTest
@Transactional
class BonusPointHistServiceImplTest {

    @Autowired
    BonusPointHistService bonusPointHistService;

    @Test
    public void 보너스포인트내역_저장() throws Exception {
        // given
        String[] imgList = {UUID.randomUUID().toString(), UUID.randomUUID().toString()};
        EventDTO eventDTO = new EventDTO("REVIEW",
                Action.ADD,
                UUID.randomUUID().toString(),
                "좋았다",
                imgList,
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString());

        BonusPointHist bonusPointHist = BonusPointHist.createBonusPointHist(eventDTO, 1);

        // when
        Long bpHistId = bonusPointHistService.registryBonusPointHist(bonusPointHist);
        BonusPointHist savePointHist = bonusPointHistService.getBonusPointHist(bpHistId);

        // then
        Assertions.assertThat(bonusPointHist).isEqualTo(savePointHist);
    }

    @Test
    public void 해당장소의_가장최근포인트_조회() throws Exception {
        // given
        String[] imgList = {UUID.randomUUID().toString(), UUID.randomUUID().toString()};
        EventDTO eventDTO = new EventDTO("REVIEW",
                Action.ADD,
                UUID.randomUUID().toString(),
                "좋았다",
                imgList,
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString());

        BonusPointHist bonusPointHist = BonusPointHist.createBonusPointHist(eventDTO, 1);
        bonusPointHistService.registryBonusPointHist(bonusPointHist);

        // when
        BonusPointHist recentBonusPointHist = bonusPointHistService.getRecentBonusPointHist(bonusPointHist.getPlaceId());

        // then
        Assertions.assertThat(recentBonusPointHist.getPlacePoint()).isEqualTo(1);
    }
}