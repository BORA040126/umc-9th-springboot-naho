package com.example.UMC_Spring.domain.review.service;

import com.example.UMC_Spring.domain.review.dto.ReviewPreviewListDTO;

import org.springframework.data.domain.Pageable;

public interface ReviewQueryService {

    ReviewPreviewListDTO getUserReviewList(Long memberId, int page, int size);
}

