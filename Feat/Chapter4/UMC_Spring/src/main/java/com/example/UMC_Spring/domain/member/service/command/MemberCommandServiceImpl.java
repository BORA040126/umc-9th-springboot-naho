package com.example.UMC_Spring.domain.member.service.command;


import com.example.UMC_Spring.domain.member.converter.MemberConverter;
import com.example.UMC_Spring.domain.member.dto.MemberReqDTO;
import com.example.UMC_Spring.domain.member.dto.MemberResDTO;
import com.example.UMC_Spring.domain.member.entity.Member;
import com.example.UMC_Spring.domain.member.repository.MemberRepo;
import com.example.UMC_Spring.global.auth.enums.Role;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {
    private final MemberRepo memberRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public MemberResDTO.JoinDTO signup(
            MemberReqDTO.JoinDTO dto
    ) {

        String salt=passwordEncoder.encode(dto.password());
        Member member=MemberConverter.toMember(dto, salt, Role.ROLE_USER);
        Member savedMember=memberRepo.save(member);

        return MemberConverter.toJoinDTO(savedMember);
    }
}
