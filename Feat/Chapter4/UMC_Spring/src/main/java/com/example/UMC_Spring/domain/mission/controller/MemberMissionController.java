package com.example.UMC_Spring.domain.mission.controller;



import com.example.UMC_Spring.domain.mission.service.MemberMissionCommandService;
import com.example.UMC_Spring.global.apiPayload.ApiResponse;
import com.example.UMC_Spring.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(
            summary="멤버별 미션 할당",
            description = "missionId와 memberId를 이용하여 미션을 할당합니다"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "실패")
    })
    @PostMapping("/{memberId}/missions/{missionId}")
    public ApiResponse<Long> assignMission(
            @PathVariable Long memberId,
            @PathVariable Long missionId
    ){
        Long memberMissionId=memberMissionCommandService.assignMissionToMember(memberId,missionId);

        return ApiResponse.onSuccess((GeneralSuccessCode.OK));
    }

}
