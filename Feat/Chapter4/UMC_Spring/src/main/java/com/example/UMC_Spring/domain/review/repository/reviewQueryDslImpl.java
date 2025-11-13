package com.example.UMC_Spring.domain.review.repository;

import com.example.UMC_Spring.domain.member.entity.Member;
import com.example.UMC_Spring.domain.review.entity.QReview;
import com.example.UMC_Spring.domain.review.entity.Review;
import com.example.UMC_Spring.domain.store.entity.QStore;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class reviewQueryDslImpl implements reviewQueryDsl {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Review> searchMyReviews(Member member,
                                        String storeName,
                                        Integer starGroup,
                                        Pageable pageable) {

        QReview review = QReview.review;
        QStore store = QStore.store;

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(review.member.eq(member));

        if (storeName != null && !storeName.isBlank()) {
            builder.and(review.store.name.eq(storeName));
        }

        if (starGroup != null) {
            float min = starGroup;
            float max = starGroup + 1;
            builder.and(review.star.goe(min).and(review.star.lt(max)));
        }

        List<Review> content = queryFactory
                .selectFrom(review)
                .join(review.store, store).fetchJoin()
                .where(builder)
                .orderBy(review.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long total = queryFactory
                .select(review.count())
                .from(review)
                .where(builder)
                .fetchOne();

        return new PageImpl<>(content, pageable, total != null ? total : 0);
    }
}



