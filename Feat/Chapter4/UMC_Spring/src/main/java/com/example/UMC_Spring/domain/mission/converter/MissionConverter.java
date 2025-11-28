package com.example.UMC_Spring.domain.mission.converter;

import com.example.UMC_Spring.domain.mission.dto.MissionListDTO;
import com.example.UMC_Spring.domain.mission.dto.MissionPreviewDTO;
import com.example.UMC_Spring.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;

import java.util.List;

public class MissionConverter {
    public static MissionPreviewDTO toMissionPreviewDTO(Mission mission){
        return MissionPreviewDTO.builder()
                .MissionId(mission.getMissionId())
                .conditional(mission.getConditional())
                .point(mission.getPoint())
                .build();
    }

    public static MissionListDTO toMissionListDTO(Page<Mission> missionPage){
        List<MissionPreviewDTO> missionList=missionPage.getContent().stream()
                .map(MissionConverter::toMissionPreviewDTO)
                .toList();

        return MissionListDTO.builder()
                .missionList(missionList)
                .listSize(missionList.size())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .build();
    }
}
