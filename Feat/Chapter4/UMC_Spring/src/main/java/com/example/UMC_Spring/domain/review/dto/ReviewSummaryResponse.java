package com.example.UMC_Spring.domain.review.dto;
import com.example.UMC_Spring.domain.review.dto.ReviewSummaryResponse;

public record ReviewSummaryResponse(
        String storeName,
        String memberName,
        Float star,
        String content
) {}

