package com.example.UMC_Spring.domain.member.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="member_food")
public class MemberFood {
    //ID 자동생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //다대일 관계
    //Memeber의 ID
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member memberId;


    //다대일 관계
    //Food의 ID
    @ManyToOne
    @JoinColumn(name="food_id")
    private Food foodId;

}
