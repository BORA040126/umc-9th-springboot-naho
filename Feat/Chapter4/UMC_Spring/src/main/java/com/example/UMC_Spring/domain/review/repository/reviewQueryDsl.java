package com.example.UMC_Spring.domain.review.repository;

import com.querydsl.core.types.Predicate;
import com.example.UMC_Spring.domain.review.entity.Review;
import java.util.List;

public interface reviewQueryDsl {
    List<Review> searchReview(Predicate predicate);
}
