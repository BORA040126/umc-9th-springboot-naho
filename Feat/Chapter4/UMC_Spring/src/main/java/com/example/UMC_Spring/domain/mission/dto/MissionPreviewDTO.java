package com.example.UMC_Spring.domain.mission.dto;

import lombok.Builder;

@Builder
public record MissionPreviewDTO(
        Long MissionId,
        String conditional,
        Integer point
) {
}
