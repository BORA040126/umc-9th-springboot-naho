package com.example.UMC_Spring.domain.member.converter;

import com.example.UMC_Spring.domain.member.dto.MemberReqDTO;
import com.example.UMC_Spring.domain.member.dto.MemberResDTO;
import com.example.UMC_Spring.domain.member.entity.Member;
import com.example.UMC_Spring.global.auth.enums.Role;

public class MemberConverter {
    public static MemberResDTO.JoinDTO toJoinDTO(Member member){
        return MemberResDTO.JoinDTO.builder().memberId(member.getMemberId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    public static Member toMember(MemberReqDTO.JoinDTO dto, String password, Role role){
        return Member.builder()
                .memberName(dto.memberName())
                .email(dto.email())
                .password(password)
                .role(role)
                .memberBirthday(dto.memberBirthday())
                .memberAddress(dto.memberAddress())
                .memberDetailAddress(dto.memberDetailAddress())
                .gender(dto.gender())
                .build();
    }
    
    public static MemberResDTO.LoginDTO toLoginDTO(Member member,String accessToken){
        return MemberResDTO.LoginDTO.builder()
                .memberId(member.getMemberId())
                .accessToken(accessToken).build();
    }
}
