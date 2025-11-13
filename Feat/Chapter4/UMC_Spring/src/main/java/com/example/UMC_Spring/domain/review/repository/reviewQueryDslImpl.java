package com.example.UMC_Spring.domain.review.repository;

import com.example.UMC_Spring.domain.review.entity.QReview;
import com.example.UMC_Spring.domain.review.entity.Review;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class reviewQueryDslImpl implements reviewQueryDsl {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Review> searchReview(Predicate predicate) {
        QReview review = QReview.review;
        return queryFactory.selectFrom(review).where(predicate).fetch();
    }
}

