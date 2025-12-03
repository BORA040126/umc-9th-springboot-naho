package com.example.UMC_Spring.domain.mission.service;

import com.example.UMC_Spring.domain.member.entity.Member;
import com.example.UMC_Spring.domain.member.exception.MemberException;
import com.example.UMC_Spring.domain.member.exception.code.MemberErrorCode;
import com.example.UMC_Spring.domain.member.repository.MemberRepo;
import com.example.UMC_Spring.domain.mission.entity.MemberMission;
import com.example.UMC_Spring.domain.mission.entity.Mission;
import com.example.UMC_Spring.domain.mission.exception.code.MissionErrorCode;
import com.example.UMC_Spring.domain.mission.repository.MissionRepo;
import com.example.UMC_Spring.domain.mission.repository.memberMissionRepo;
import com.example.UMC_Spring.global.apiPayload.code.BaseErrorCode;
import com.example.UMC_Spring.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandService {

    private final MemberRepo  memberRepo;
    private final MissionRepo missionRepo;
    private final memberMissionRepo memberMissionRepo;


    public Long assignMissionToMember(Long memberId, Long MissionId){
        Member member = memberRepo.findById(memberId)
                .orElseThrow(()->new MemberException(MemberErrorCode.NOT_FOUND));
        Mission mission = missionRepo.findById(MissionId)
                .orElseThrow(()->new GeneralException(MissionErrorCode.NOT_FOUND));

        if(memberMissionRepo.existsByMemberAndMission(member, mission)){
            throw new MemberException(MemberErrorCode.NOT_FOUND);
        }

        MemberMission  memberMission = new MemberMission();
        memberMission.setMember(member);
        memberMission.setMission(mission);

        memberMissionRepo.save(memberMission);
        return memberMission.getId();
    }
}
