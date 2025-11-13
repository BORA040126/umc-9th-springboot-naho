package com.example.UMC_Spring.domain.review.repository;

import com.example.UMC_Spring.domain.member.entity.Member;
import com.example.UMC_Spring.domain.review.entity.Review;
import com.example.UMC_Spring.domain.store.entity.Store;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface reviewRepo extends JpaRepository<Review, Long>,reviewQueryDsl {

    @Query(value = "SELECT r FROM Review r WHERE r.member = :member ORDER BY r.createdAt DESC",
            countQuery = "SELECT COUNT(r) FROM Review r WHERE r.member = :member")
    Page<Review> findRecentByMember(@Param("member") Member member, Pageable pageable);

    @Query("SELECT COUNT(r) FROM Review r WHERE r.member = :member")
    long countByMember(@Param("member") Member member);

    @Query("SELECT r FROM Review r WHERE r.store = :store")
    Page<Review> findByStore(@Param("store") Store store, Pageable pageable);

    @Query("SELECT AVG(r.star) FROM Review r WHERE r.store = :store")
    Float findAverageStarByStore(@Param("store") Store store);

    @Query("SELECT COUNT(r) FROM Review r WHERE r.store = :store")
    Long countReviewsByStore(@Param("store") Store store);
}


