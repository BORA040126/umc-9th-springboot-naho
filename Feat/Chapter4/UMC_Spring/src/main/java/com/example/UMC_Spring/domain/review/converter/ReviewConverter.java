package com.example.UMC_Spring.domain.review.converter;

import com.example.UMC_Spring.domain.review.dto.ReviewPreviewDTO;
import com.example.UMC_Spring.domain.review.dto.ReviewPreviewListDTO;
import com.example.UMC_Spring.domain.review.dto.ReviewResDTO;
import com.example.UMC_Spring.domain.review.entity.Review;
import com.example.UMC_Spring.domain.review.service.ReviewQueryService;
import org.hibernate.query.Page;

import java.util.ArrayList;
import java.util.List;

public class ReviewConverter {
    public static ReviewPreviewDTO toReviewPreviewDTO(Review review) {
        return ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getMemberName())
                .star(review.getStar())
                .body(review.getContent())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

}

