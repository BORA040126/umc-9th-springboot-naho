package com.example.UMC_Spring.domain.member.dto;
import com.example.UMC_Spring.domain.member.entity.Member;
import com.example.UMC_Spring.domain.member.enums.Gender;
import com.example.UMC_Spring.global.annotation.ExistFoods;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {
    public record JoinDTO(
            String memberName,
            Gender gender,
            LocalDate memberBirthday,
            String memberAddress,
            String memberDetailAddress,
            @ExistFoods
            List<Long> preferCategory
    ){}
}
