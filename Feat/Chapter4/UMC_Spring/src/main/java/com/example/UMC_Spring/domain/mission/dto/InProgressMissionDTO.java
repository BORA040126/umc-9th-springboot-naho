package com.example.UMC_Spring.domain.mission.dto;


import lombok.Builder;

@Builder
public record InProgressMissionDTO(
        Long memberMissionId,
        Long missionId,
        String missionContent,
        boolean isComplete
) {

}
