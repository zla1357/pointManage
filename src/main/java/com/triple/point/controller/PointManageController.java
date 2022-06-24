package com.triple.point.controller;

import com.triple.point.domain.dto.EventDTO;
import com.triple.point.domain.dto.UserPointDTO;

public interface PointManageController {
    String event(EventDTO eventDTO);
    UserPointDTO getUserPoint(String userId);
}
