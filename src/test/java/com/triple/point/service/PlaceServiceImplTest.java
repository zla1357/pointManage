package com.triple.point.service;

import com.triple.point.domain.Place;
import com.triple.point.domain.User;
import com.triple.point.repository.PlaceRepository;
import com.triple.point.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@SpringBootTest
@Transactional
class PlaceServiceImplTest {

    @Autowired
    PlaceService placeService;
    @Autowired
    PlaceRepository placeRepository;

    @Test
    public void 장소_저장() throws Exception {
        // given
        Place place = Place.createPlace("place1");

        // when
        UUID saveId = placeService.registryPlace(place);
        Place savePlace = placeRepository.getPlace(saveId);

        // then
        Assertions.assertThat(place).isEqualTo(savePlace);
    }

}