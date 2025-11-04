package com.example.UMC_Spring.domain.review.entity;

import com.example.UMC_Spring.domain.member.entity.Member;
import com.example.UMC_Spring.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="review")
public class Review {
    //기본 ID 자동생성
    @Id
    @GeneratedValue
    private Long reviewId;

    //생성일자
    @CreatedDate
    @Column(name="created_at",nullable = false, updatable = false)
    private LocalDateTime createdAt;

    //별개수(소숫점 까지)
    @Column(name="star",nullable = false)
    private Float star;

    //다대일 관계, 가게 ID
    @ManyToOne
    @JoinColumn(name="store_id")
    private Store store;

    //다대일 관계, USER_ID
    @ManyToOne
    @JoinColumn(name="user_id")
    private Member member;
}
