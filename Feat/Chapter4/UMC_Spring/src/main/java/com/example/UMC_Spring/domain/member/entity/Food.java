package com.example.UMC_Spring.domain.member.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="food")
public class Food {
    //음식 ID, 자동생성
    @Id
    @GeneratedValue
    private Long foodId;

    //음식명
    @Column(name="name")
    private String name;

}
