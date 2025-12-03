package com.example.UMC_Spring.domain.mission.controller;

import com.example.UMC_Spring.domain.mission.dto.MissionListDTO;
import com.example.UMC_Spring.domain.mission.dto.MissionReqDTO;
import com.example.UMC_Spring.global.apiPayload.ApiResponse;
import com.example.UMC_Spring.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


public interface MissionControllerDocs {
    @Operation(
            summary="가게별 미션 생성",
            description = "가게 Id를 이용해 미션을 만듭니다."
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "실패")
    })
    ApiResponse<?> createMission(
            @PathVariable Long StoreId
            ,@RequestBody MissionReqDTO.MissionCreate dto
    );

    @Operation(
            summary="가게별 미션 조회",
            description = "storeId 별로 미션을 조회합니다"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "실패")
    })
    ApiResponse<MissionListDTO> getStoresMissions(
            @PathVariable Long storeId,
            @RequestParam(defaultValue = "1") int page
    );
}
