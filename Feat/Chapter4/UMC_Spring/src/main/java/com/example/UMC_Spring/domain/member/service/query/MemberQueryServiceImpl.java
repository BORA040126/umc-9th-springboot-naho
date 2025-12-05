package com.example.UMC_Spring.domain.member.service.query;

import com.example.UMC_Spring.domain.member.converter.MemberConverter;
import com.example.UMC_Spring.domain.member.dto.MemberReqDTO;
import com.example.UMC_Spring.domain.member.dto.MemberResDTO;
import com.example.UMC_Spring.domain.member.entity.Member;
import com.example.UMC_Spring.domain.member.exception.MemberException;
import com.example.UMC_Spring.domain.member.exception.code.MemberErrorCode;
import com.example.UMC_Spring.domain.member.repository.MemberRepo;
import com.example.UMC_Spring.global.auth.CustomUserDetails;
import com.example.UMC_Spring.global.auth.jwt.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{
    private final MemberRepo memberRepo;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder encoder;

    @Override
    public MemberResDTO.LoginDTO login(
            MemberReqDTO.@Valid LoginDTO dto
    )
    {
        Member member=memberRepo.findByEmail(dto.email())
                .orElseThrow(()->new MemberException(MemberErrorCode.NOT_FOUND));

        if(!encoder.matches(dto.password(),member.getPassword())){
            throw new MemberException(MemberErrorCode.UNAUTHORIZED);
        }

        CustomUserDetails userDetails = new CustomUserDetails(member);
        String accessToken= jwtUtil.createAccessToken(userDetails);
        return MemberConverter.toLoginDTO(member,accessToken);
    }
}
