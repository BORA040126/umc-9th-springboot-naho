package com.example.UMC_Spring.domain.member.service.query;

import com.example.UMC_Spring.domain.member.dto.MemberReqDTO;
import com.example.UMC_Spring.domain.member.dto.MemberResDTO;
import jakarta.validation.Valid;

public interface MemberQueryService {
    MemberResDTO.LoginDTO login(MemberReqDTO.@Valid LoginDTO dto);
}
