package com.example.UMC_Spring.domain.review.service;

import com.example.UMC_Spring.domain.member.entity.Member;
import com.example.UMC_Spring.domain.member.repository.MemberRepo;
import com.example.UMC_Spring.domain.review.dto.ReviewSummaryResponse;
import com.example.UMC_Spring.domain.review.entity.Review;
import com.example.UMC_Spring.domain.review.repository.reviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final reviewRepo reviewRepo;
    private final MemberRepo memberRepo;


    public Page<ReviewSummaryResponse> getMySimpleReviews(
            Long memberId,
            String storeName,
            Integer starGroup,
            Pageable pageable
    ) {
        Member member = memberRepo.findById(memberId)
                .orElseThrow(() -> new RuntimeException("member not found"));

        Page<Review> reviewPage =
                reviewRepo.searchMyReviews(member, storeName, starGroup, pageable);

        return reviewPage.map(r -> new ReviewSummaryResponse(
                r.getStore().getName(),
                r.getMember().getMemberName(),
                r.getStar(),
                r.getContent()
        ));
    }
}




