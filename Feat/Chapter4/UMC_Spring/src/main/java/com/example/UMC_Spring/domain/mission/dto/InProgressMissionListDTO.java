package com.example.UMC_Spring.domain.mission.dto;


import lombok.Builder;

import java.util.List;

@Builder
public record InProgressMissionListDTO(
        List<InProgressMissionDTO> missionList,
        Integer listSize,
        Integer totalPage,
        Long totalElements,
        Boolean isFirst,
        Boolean isLast

) {
}
