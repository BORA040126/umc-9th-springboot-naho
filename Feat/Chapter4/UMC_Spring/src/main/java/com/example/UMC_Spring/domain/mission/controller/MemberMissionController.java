package com.example.UMC_Spring.domain.mission.controller;



import com.example.UMC_Spring.domain.mission.service.MemberMissionCommandService;
import com.example.UMC_Spring.global.apiPayload.ApiResponse;
import com.example.UMC_Spring.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberMissionController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/{memberId}/missions/{missionId}")
    public ApiResponse<Long> assignMission(
            @PathVariable Long memberId,
            @PathVariable Long missionId
    ){
        Long memberMissionId=memberMissionCommandService.assignMissionToMember(memberId,missionId);

        return ApiResponse.onSuccess((GeneralSuccessCode.OK));
    }

}
