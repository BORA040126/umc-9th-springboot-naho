package com.example.UMC_Spring.domain.member.service.command;


import com.example.UMC_Spring.domain.member.converter.MemberConverter;
import com.example.UMC_Spring.domain.member.dto.MemberReqDTO;
import com.example.UMC_Spring.domain.member.dto.MemberResDTO;
import com.example.UMC_Spring.domain.member.entity.Food;
import com.example.UMC_Spring.domain.member.entity.Member;
import com.example.UMC_Spring.domain.member.entity.MemberFood;
import com.example.UMC_Spring.domain.member.exception.FoodException;
import com.example.UMC_Spring.domain.member.exception.code.FoodErrorCode;
import com.example.UMC_Spring.domain.member.repository.FoodRepo;
import com.example.UMC_Spring.domain.member.repository.MemberFoodRepo;
import com.example.UMC_Spring.domain.member.repository.MemberRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        if(dto.preferCategory().size()>1){
            List<MemberFood> memberFoodList = new ArrayList<>();
            for(Long id:dto.preferCategory()){
                Food food=foodRepo.findById(id)
                        .orElseThrow(() -> new FoodException(FoodErrorCode.NOT_FOUND));

                MemberFood memberFood=MemberFood.builder()
                        .memberId(member)
                        .foodId(food)
                        .build();
                memberFoodList.add(memberFood);
            }
            memberFoodRepo.saveAll(memberFoodList);
        }
        return MemberConverter.toJoinDTO(member);
    }
}
