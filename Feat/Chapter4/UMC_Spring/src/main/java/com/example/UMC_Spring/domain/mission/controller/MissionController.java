package com.example.UMC_Spring.domain.mission.controller;


import com.example.UMC_Spring.domain.mission.dto.MissionReqDTO;
import com.example.UMC_Spring.domain.mission.service.MissionCommandService;
import com.example.UMC_Spring.global.apiPayload.ApiResponse;
import com.example.UMC_Spring.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/missions")
@RequiredArgsConstructor
public class MissionController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/{MissionId}")
    public ApiResponse<?> createMission(
            @PathVariable Long MissionId
            ,@RequestBody MissionReqDTO.Create dto){
        Long missionId= missionCommandService.createMission(MissionId, dto);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK);
    }
}
