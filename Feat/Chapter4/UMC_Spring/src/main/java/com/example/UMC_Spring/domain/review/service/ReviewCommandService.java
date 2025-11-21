package com.example.UMC_Spring.domain.review.service;


import com.example.UMC_Spring.domain.review.dto.ReviewReqDTO;
import com.example.UMC_Spring.domain.review.entity.Review;

public interface ReviewCommandService {
    Long createReview(Long memberId, Long storeId, ReviewReqDTO.Create dto);

}
