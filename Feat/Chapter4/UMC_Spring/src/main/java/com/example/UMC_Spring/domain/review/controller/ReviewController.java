package com.example.UMC_Spring.domain.review.controller;

import com.example.UMC_Spring.domain.review.dto.ReviewSummaryResponse;
import com.example.UMC_Spring.domain.review.service.ReviewService;
import com.example.UMC_Spring.global.apiPayload.ApiResponse;
import com.example.UMC_Spring.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/me/simple")
    public ApiResponse<Page<ReviewSummaryResponse>> getMyReviewsSimple(
            @RequestParam Long memberId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Integer starGroup,
            Pageable pageable
    ) {
        Page<ReviewSummaryResponse> result =
                reviewService.getMySimpleReviews(memberId, storeName, starGroup, pageable);

        return ApiResponse.onSuccess(GeneralSuccessCode.REVIEW_FETCH_SUCCESS, result);
    }

}

