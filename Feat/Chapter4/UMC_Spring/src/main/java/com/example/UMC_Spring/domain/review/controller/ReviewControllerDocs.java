package com.example.UMC_Spring.domain.review.controller;

import com.example.UMC_Spring.domain.review.dto.ReviewPreviewListDTO;
import com.example.UMC_Spring.domain.review.dto.ReviewReqDTO;
import com.example.UMC_Spring.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewControllerDocs {
    @Operation(
            summary="멤버 기반 리뷰 조회",
            description = "멤버가 작성한 리뷰를 표시합니다"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "실패")
    })
    ApiResponse<ReviewPreviewListDTO> getUserReviews(
            @PathVariable Long memberId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    );


    @Operation(
            summary="가게에 리뷰 작성",
            description = "storeId와 memberId를 이용하여 리뷰를 가게에 멤버가 리뷰를 작성합니다"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "실패")
    })

    ApiResponse<?> createReview(
            @PathVariable Long storeId,
            @RequestParam Long memberId,
            @RequestBody ReviewReqDTO.Create dto

    );
}
