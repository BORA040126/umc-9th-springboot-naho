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
public class ReviewController implements ReviewControllerDocs{

    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;


    @PostMapping("/")
    public ApiResponse<?> createReview(
            @PathVariable Long storeId,
            @RequestParam Long memberId,
            @RequestBody ReviewReqDTO.Create dto

    ) {
        Long reviewId= reviewCommandService.createReview(memberId, storeId, dto);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK);
    }


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


