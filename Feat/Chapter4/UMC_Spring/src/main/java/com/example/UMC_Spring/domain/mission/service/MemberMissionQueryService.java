package com.example.UMC_Spring.domain.mission.service;

import com.example.UMC_Spring.domain.mission.dto.InProgressMissionDTO;
import com.example.UMC_Spring.domain.mission.dto.InProgressMissionListDTO;

public interface MemberMissionQueryService {
    InProgressMissionListDTO getInProgressMissions(Long memberId, int page);
}
