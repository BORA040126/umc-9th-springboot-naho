package com.example.UMC_Spring.domain.member.dto;
import com.example.UMC_Spring.domain.member.entity.Member;
import lombok.Builder;

import java.time.LocalDateTime;

public class MemberResDTO {
    @Builder
    public record JoinDTO(
            Long memberId,
            LocalDateTime createdAt

    ){}

    @Builder
    public record LoginDTO(
            Long memberId,
            String accessToken
    ){

    }
}
