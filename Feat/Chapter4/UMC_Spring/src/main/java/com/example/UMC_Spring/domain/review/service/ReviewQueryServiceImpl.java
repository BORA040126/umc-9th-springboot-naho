package com.example.UMC_Spring.domain.review.service;

import com.example.UMC_Spring.domain.review.converter.ReviewConverter;
import com.example.UMC_Spring.domain.review.dto.ReviewPreviewDTO;
import com.example.UMC_Spring.domain.review.dto.ReviewPreviewListDTO;
import com.example.UMC_Spring.domain.review.entity.Review;
import com.example.UMC_Spring.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public ReviewPreviewListDTO getUserReviewList(Long memberId, int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        Page<Review> reviewsPage = reviewRepository.findByMemberId(memberId, pageable);


        List<ReviewPreviewDTO> reviewList = reviewsPage.getContent().stream()
                .map(ReviewConverter::toReviewPreviewDTO)
                .toList();


        return ReviewPreviewListDTO.builder()
                .reviewList(reviewList)
                .listSize(reviewList.size())
                .totalPage(reviewsPage.getTotalPages())
                .totalElements(reviewsPage.getTotalElements())
                .isFirst(reviewsPage.isFirst())
                .isLast(reviewsPage.isLast())
                .build();
    }
}
