package com.example.UMC_Spring.domain.review.service;

import com.example.UMC_Spring.domain.member.entity.Member;
import com.example.UMC_Spring.domain.member.exception.MemberException;
import com.example.UMC_Spring.domain.member.exception.code.MemberErrorCode;
import com.example.UMC_Spring.domain.member.repository.MemberRepo;
import com.example.UMC_Spring.domain.review.dto.ReviewReqDTO;
import com.example.UMC_Spring.domain.review.entity.Review;
import com.example.UMC_Spring.domain.review.repository.reviewRepo;
import com.example.UMC_Spring.domain.store.entity.Store;
import com.example.UMC_Spring.domain.store.exception.code.StoreErrorCode;
import com.example.UMC_Spring.domain.store.repository.StoreRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final reviewRepo reviewRepo;
    private final StoreRepo storeRepo;
    private final MemberRepo memberRepo;

    @Transactional
    public Long createReview(Long memberId, Long storeId, ReviewReqDTO.Create dto) {
        Member member = memberRepo.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));
        Store store = storeRepo.findById(storeId)
                .orElseThrow(()->new MemberException(StoreErrorCode.NOT_FOUND));

        Review review = Review.builder()
                .member(member)
                .store(store)
                .content(dto.content())
                .star(dto.star())
                .build();

        reviewRepo.save(review);

        return review.getReviewId();
    }

}
