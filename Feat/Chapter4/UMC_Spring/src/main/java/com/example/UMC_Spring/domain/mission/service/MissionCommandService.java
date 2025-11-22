package com.example.UMC_Spring.domain.mission.service;

import com.example.UMC_Spring.domain.mission.dto.MissionReqDTO;

public interface MissionCommandService {
    Long createMission(Long storeId, MissionReqDTO.MissionCreate dto);
}
