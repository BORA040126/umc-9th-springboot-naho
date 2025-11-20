package com.example.UMC_Spring.domain.member.service.command;

import com.example.UMC_Spring.domain.member.dto.MemberReqDTO;
import com.example.UMC_Spring.domain.member.dto.MemberResDTO;

public interface MemberCommandService {
    MemberResDTO.JoinDTO signup(MemberReqDTO.JoinDTO dto);
}
