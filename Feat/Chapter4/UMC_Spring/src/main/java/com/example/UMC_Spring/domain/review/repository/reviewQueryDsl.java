package com.example.UMC_Spring.domain.review.repository;

import com.example.UMC_Spring.domain.member.entity.Member;
import com.example.UMC_Spring.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface reviewQueryDsl {
    Page<Review> searchMyReviews(Member member,
                                 String storeName,
                                 Integer starGroup,
                                 Pageable pageable);
}
