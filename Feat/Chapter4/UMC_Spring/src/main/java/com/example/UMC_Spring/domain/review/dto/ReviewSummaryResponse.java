package com.example.UMC_Spring.domain.review.dto;

public record ReviewSummaryResponse(
        String storeName,
        String memberName,
        Float star,
        String content
) {}

