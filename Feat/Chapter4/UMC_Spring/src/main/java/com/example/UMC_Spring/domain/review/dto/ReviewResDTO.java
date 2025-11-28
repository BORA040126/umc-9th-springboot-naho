package com.example.UMC_Spring.domain.review.dto;

import java.util.List;
import lombok.Builder;

import java.time.LocalDate;

public class ReviewResDTO {

    @Builder
    public record ReviewPreViewListDTO(
            List<ReviewPreviewDTO> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record ReviewPreviewDTO(
            String ownerNickname,
            Float star,
            String body,
            LocalDate createdAt
    )
    {

    }
}
