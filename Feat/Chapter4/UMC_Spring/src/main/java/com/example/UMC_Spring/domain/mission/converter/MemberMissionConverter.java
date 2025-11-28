package com.example.UMC_Spring.domain.mission.converter;

import com.example.UMC_Spring.domain.mission.dto.InProgressMissionDTO;
import com.example.UMC_Spring.domain.mission.dto.InProgressMissionListDTO;
import com.example.UMC_Spring.domain.mission.entity.MemberMission;
import org.springframework.data.domain.Page;

import java.util.List;

public class MemberMissionConverter {
    public static InProgressMissionDTO toInProgressMissionDTO(MemberMission memberMission) {
        return InProgressMissionDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionId(memberMission.getMission().getMissionId())
                .missionContent(memberMission.getMission().getConditional())
                .isComplete(memberMission.isComplete())
                .build();
    }

    public static InProgressMissionListDTO toInProgressMissionListDTO(Page<MemberMission> page) {

        List<InProgressMissionDTO> missionList = page.getContent().stream()
                .map(MemberMissionConverter::toInProgressMissionDTO)
                .toList();

        return InProgressMissionListDTO.builder()
                .missionList(missionList)
                .listSize(missionList.size())
                .totalPage(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .build();

    }
}
