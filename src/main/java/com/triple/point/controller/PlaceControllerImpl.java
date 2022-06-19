package com.triple.point.controller;

import com.triple.point.domain.Place;
import com.triple.point.domain.dto.PlaceDTO;
import com.triple.point.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class PlaceControllerImpl implements PlaceController {

    private final PlaceService placeService;

    @PostMapping("place")
    @ResponseBody
    @Override
    public String registryPlace(@RequestParam String name) {

        PlaceDTO placeDTO = new PlaceDTO(name);
        UUID uuid = placeService.registryPlace(placeDTO.mapToEntity());

        return "OK";
    }

    @GetMapping("place")
    @ResponseBody
    @Override
    public PlaceDTO getPlace(@RequestParam String placeId) {

        UUID placeUUID = UUIDConverter.convertFromString(placeId);
        Place place = placeService.getPlace(placeUUID);

        return PlaceDTO.from(place);
    }
}
