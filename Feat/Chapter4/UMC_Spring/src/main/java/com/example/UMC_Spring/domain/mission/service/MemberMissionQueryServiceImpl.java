package com.example.UMC_Spring.domain.mission.service;

import com.example.UMC_Spring.domain.member.entity.Member;
import com.example.UMC_Spring.domain.member.exception.MemberException;
import com.example.UMC_Spring.domain.member.exception.code.MemberErrorCode;
import com.example.UMC_Spring.domain.member.repository.MemberRepo;
import com.example.UMC_Spring.domain.mission.converter.MemberMissionConverter;
import com.example.UMC_Spring.domain.mission.dto.InProgressMissionListDTO;
import com.example.UMC_Spring.domain.mission.entity.MemberMission;
import com.example.UMC_Spring.domain.mission.repository.memberMissionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final memberMissionRepo memberMissionRepo;
    private final MemberRepo memberRepo;

    @Override
    public InProgressMissionListDTO getInProgressMissions(Long memberId, int pageIndex){
        Member member = memberRepo.findById(memberId)
                .orElseThrow(()->new MemberException(MemberErrorCode.NOT_FOUND));

        Pageable pageable= PageRequest.of(pageIndex,10, Sort.by(Sort.Direction.DESC,"Id"));

        Page<MemberMission> memberMissionPage = memberMissionRepo.findIncompleteByMember(member,pageable);

        return MemberMissionConverter.toInProgressMissionListDTO(memberMissionPage);
}}

