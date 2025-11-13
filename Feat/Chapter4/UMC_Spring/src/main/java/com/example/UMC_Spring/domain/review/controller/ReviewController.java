package com.example.UMC_Spring.domain.review.controller;

import com.example.UMC_Spring.domain.review.dto.ReviewSummaryResponse;
import com.example.UMC_Spring.domain.review.entity.Review;
import com.example.UMC_Spring.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/me")
    public Page<Review> getMyReviews(
            @RequestParam Long memberId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Integer starGroup,
            Pageable pageable
    ) {
        return reviewService.getMyReviews(memberId, storeName, starGroup, pageable);
    }

    @GetMapping("/me/simple")
    public Page<ReviewSummaryResponse> getMyReviewsSimple(
            @RequestParam Long memberId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Integer starGroup,
            Pageable pageable
    ) {
        return reviewService.getMyReviewsSimple(memberId, storeName, starGroup, pageable);
    }
}

