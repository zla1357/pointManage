package com.triple.point.controller;

import com.triple.point.domain.Point;
import com.triple.point.domain.dto.EventDTO;
import com.triple.point.domain.dto.UserPointDTO;
import com.triple.point.service.EventService;
import com.triple.point.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class PointManageControllerImpl implements PointManageController {

    private final EventService eventService;
    private final PointService pointService;

    @PostMapping("events")
    @ResponseBody
    @Override
    public String event(@RequestBody EventDTO eventDTO) {
        try {
            eventService.reviewEvent(eventDTO);
        } catch(IllegalArgumentException e) {
            return e.getMessage();
        }
        return "OK";
    }

    @GetMapping("point")
    @ResponseBody
    @Override
    public UserPointDTO getUserPoint(String userId) {
        Point userPoint = pointService.getPointByUserId(userId);

        return new UserPointDTO(userPoint.getUserId(), userPoint.getPointAmount());
    }
}
