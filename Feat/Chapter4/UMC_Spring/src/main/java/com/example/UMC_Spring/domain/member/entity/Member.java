package com.example.UMC_Spring.domain.member.entity;

import com.example.UMC_Spring.domain.member.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="member")
public class Member {

    //사용자 ID
    @Id
    @GeneratedValue
    private Long memberId;

    //이름
    @Column(name="name",nullable = false)
    private String memberName;

    //성별, Enum을 통해 범위 지정
    @Enumerated(EnumType.STRING)
    @Column(name="gender",nullable = false, columnDefinition = "String DEFAULT NONE")
    private Gender gender;

    //생년월일
    @Column(name="birth",nullable = false)
    private LocalDate memberBirthday;

    //주소
    @Column(name="address",nullable = false)
    private String memberAddress;

    //상세주소
    @Column(name="detailAddress")
    private String memberDetailAddress;

    //이메일
    @Column(name="email",nullable = false)
    private String memberEmail;

    //포인트
    //기본 값 0으로 지정
    @Column(name = "point", nullable = false, columnDefinition = "BIGINT DEFAULT 0")
    private Long memberPoint;


    //전화번호
    @Column(name="phoneNumber")
    private String memberPhoneNumber;

    //생성일시, 수정불가
    @CreatedDate
    @Column(name="createdAt",nullable = false, updatable = false)
    private LocalDateTime createdAt;

    //수정일시
    @LastModifiedDate
    @Column(name="modifiedAt",nullable = false)
    private LocalDateTime updatedAt;


}
