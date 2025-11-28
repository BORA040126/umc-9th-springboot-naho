package com.example.UMC_Spring.domain.review.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record ReviewPreviewListDTO(
        List<ReviewPreviewDTO> reviewList,
        Integer listSize,
        Integer totalPage,
        Long totalElements,
        Boolean isFirst,
        Boolean isLast
) {


}
