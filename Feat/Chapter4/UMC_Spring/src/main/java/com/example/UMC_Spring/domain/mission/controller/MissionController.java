package com.example.UMC_Spring.domain.mission.controller;


import com.example.UMC_Spring.domain.mission.dto.MissionListDTO;
import com.example.UMC_Spring.domain.mission.dto.MissionReqDTO;
import com.example.UMC_Spring.domain.mission.service.MissionCommandService;
import com.example.UMC_Spring.domain.mission.service.MissionQueryService;
import com.example.UMC_Spring.global.apiPayload.ApiResponse;
import com.example.UMC_Spring.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/missions")
@RequiredArgsConstructor
public class MissionController implements MissionControllerDocs{

    private final MissionQueryService missionQueryService;
    private final MissionCommandService missionCommandService;


    @PostMapping("/{StoreId}")
    public ApiResponse<?> createMission(
            @PathVariable Long StoreId
            ,@RequestBody MissionReqDTO.MissionCreate dto
    ){
        Long MissionId= missionCommandService.createMission(StoreId, dto);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK);
    }

    @GetMapping("/{storeId}/missions")
    public ApiResponse<MissionListDTO> getStoresMissions(
            @PathVariable Long storeId,
            @RequestParam(defaultValue = "1") int page
    ){
        MissionListDTO result=missionQueryService.getMissionsByStore(storeId, page);

        return ApiResponse.onSuccessWithData(
                GeneralSuccessCode.OK,
                result
        );
    }
}
