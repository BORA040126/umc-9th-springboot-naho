package com.example.UMC_Spring.domain.review.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ReviewPreviewDTO(
        String ownerNickname,
        Float star,
        String body,
        LocalDate createdAt
) {

}
