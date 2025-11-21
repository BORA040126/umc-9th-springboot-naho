package com.example.UMC_Spring.domain.member.converter;

import com.example.UMC_Spring.domain.member.entity.Food;
import com.example.UMC_Spring.domain.member.entity.Member;
import com.example.UMC_Spring.domain.member.entity.MemberFood;

public class MemberFoodConverter {
    public static MemberFood toMemberFood(Member member, Food food){
        return MemberFood.builder()
                .memberId(member)
                .foodId(food)
                .build();
    }
}
