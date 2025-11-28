package com.example.UMC_Spring.domain.member.controller;


import com.example.UMC_Spring.domain.mission.dto.InProgressMissionListDTO;
import com.example.UMC_Spring.domain.mission.service.MemberMissionQueryService;
import com.example.UMC_Spring.global.apiPayload.ApiResponse;
import com.example.UMC_Spring.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberMissionsController {
    private final MemberMissionQueryService memberMissionQueryService;

    @GetMapping("/{memberId}/missions")
    public ApiResponse<InProgressMissionListDTO> getInProgressMissions(
            @PathVariable Long memberId,
            @RequestParam int page
    )
    {
        InProgressMissionListDTO result=
                memberMissionQueryService.getInProgressMissions(memberId,page);

        return ApiResponse.onSuccessWithData(GeneralSuccessCode.OK, result);
    }
}
