package com.example.UMC_Spring.domain.review.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="review_photo")
public class ReviewPhoto {
    //ID 자동생성
    @Id
    @GeneratedValue
    private Long reiviewPhotoId;

    //URL을 통해 PHOTO 불러올 수 있도록
    @Column(name="photo_url")
    private String photoUrl;

    //다대일 관계, REVIEW_ID 불러옴
    @ManyToOne
    @JoinColumn(name="review_id")
    private Review review;

}
