package com.example.UMC_Spring.domain.member.service.command;


import com.example.UMC_Spring.domain.member.converter.MemberConverter;
import com.example.UMC_Spring.domain.member.dto.MemberReqDTO;
import com.example.UMC_Spring.domain.member.dto.MemberResDTO;
import com.example.UMC_Spring.domain.member.entity.Member;
import com.example.UMC_Spring.domain.member.repository.FoodRepo;
import com.example.UMC_Spring.domain.member.repository.MemberFoodRepo;
import com.example.UMC_Spring.domain.member.repository.MemberRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {
    private final MemberRepo memberRepo;
    private final MemberFoodRepo memberFoodRepo;
    private final FoodRepo foodRepo;

    @Override
    @Transactional
    public MemberResDTO.JoinDTO signup(
            MemberReqDTO.JoinDTO dto
    ) {
        Member member = MemberConverter.toMember(dto);
        memberRepo.save(member);
        return null;
    }
}
