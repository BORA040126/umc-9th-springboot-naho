package com.example.UMC_Spring.domain.mission.controller;

import com.example.UMC_Spring.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

public interface MemberMissionControllerDocs {
    @Operation(
            summary="멤버별 미션 할당",
            description = "missionId와 memberId를 이용하여 미션을 할당합니다"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "실패")
    })
    ApiResponse<Long> assignMission(
            @PathVariable Long memberId,
            @PathVariable Long missionId
    );


}
