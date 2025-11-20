package com.example.UMC_Spring.domain.member.converter;

import com.example.UMC_Spring.domain.member.dto.MemberReqDTO;
import com.example.UMC_Spring.domain.member.dto.MemberResDTO;
import com.example.UMC_Spring.domain.member.entity.Member;

public class MemberConverter {
    public static MemberResDTO.JoinDTO toJoinDTO(Member member){
        return MemberResDTO.JoinDTO.builder().memberId(member.getMemberId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    public static Member toMember(MemberReqDTO.JoinDTO dto){
        return Member.builder()
                .memberName(dto.memberName())
                .memberBirthday(dto.memberBirthday())
                .memberAddress(dto.memberAddress())
                .memberDetailAddress(dto.memberDetailAddress())
                .gender(dto.gender())
                .build();
    }
}
