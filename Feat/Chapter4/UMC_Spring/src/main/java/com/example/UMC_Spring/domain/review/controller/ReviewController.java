package com.example.UMC_Spring.domain.review.controller;

import com.example.UMC_Spring.domain.review.dto.ReviewReqDTO;
import com.example.UMC_Spring.domain.review.dto.ReviewSummaryResponse;
import com.example.UMC_Spring.domain.review.service.ReviewCommandService;
import com.example.UMC_Spring.domain.review.service.ReviewService;
import com.example.UMC_Spring.global.apiPayload.ApiResponse;
import com.example.UMC_Spring.global.apiPayload.code.GeneralSuccessCode;
import com.example.UMC_Spring.global.apiPayload.code.GeneralErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{storeId}")
    public ApiResponse<?> createReview(
            @PathVariable Long storeId,
            @RequestParam Long memberId,
            @RequestBody ReviewReqDTO.Create dto

    ) {
        Long reviewId= reviewCommandService.createReview(memberId, storeId, dto);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK);
    }

}


