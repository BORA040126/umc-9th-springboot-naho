package com.example.UMC_Spring.domain.review.controller;

import com.example.UMC_Spring.domain.review.dto.ReviewPreviewListDTO;
import com.example.UMC_Spring.domain.review.dto.ReviewReqDTO;
import com.example.UMC_Spring.domain.review.dto.ReviewResDTO;
import com.example.UMC_Spring.domain.review.dto.ReviewSummaryResponse;
import com.example.UMC_Spring.domain.review.exception.code.ReviewSuccessCode;
import com.example.UMC_Spring.domain.review.service.ReviewCommandService;
import com.example.UMC_Spring.domain.review.service.ReviewQueryService;
import com.example.UMC_Spring.domain.review.service.ReviewService;
import com.example.UMC_Spring.global.apiPayload.ApiResponse;
import com.example.UMC_Spring.global.apiPayload.code.GeneralSuccessCode;
import com.example.UMC_Spring.global.apiPayload.code.GeneralErrorCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;


    @Operation(
            summary="가게에 리뷰 작성",
            description = "storeId와 memberId를 이용하여 리뷰를 가게에 멤버가 리뷰를 작성합니다"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "실패")
    })
    @PostMapping("/")
    public ApiResponse<?> createReview(
            @PathVariable Long storeId,
            @RequestParam Long memberId,
            @RequestBody ReviewReqDTO.Create dto

    ) {
        Long reviewId= reviewCommandService.createReview(memberId, storeId, dto);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK);
    }

    @Operation(
            summary="멤버 기반 리뷰 조회",
            description = "멤버가 작성한 리뷰를 표시합니다"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "실패")
    })
    @GetMapping("/{memberId}/reviews")
    public ApiResponse<ReviewPreviewListDTO> getUserReviews(
            @PathVariable Long memberId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        ReviewPreviewListDTO result= reviewQueryService.getUserReviewList(memberId, page, size);

        return ApiResponse.onSuccessWithData(GeneralSuccessCode.OK,result);
    }

}


