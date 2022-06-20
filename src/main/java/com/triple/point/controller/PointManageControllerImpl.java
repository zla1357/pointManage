package com.triple.point.controller;

import com.triple.point.domain.dto.EventDTO;
import com.triple.point.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class PointManageControllerImpl implements PointManageController {

    private final EventService eventService;

    @PostMapping("event")
    @ResponseBody
    @Override
    public String event(@RequestBody EventDTO eventDTO) {
        eventService.reviewEvent(eventDTO);
        return null;
    }
}
