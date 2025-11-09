package com.example.UMC_Spring.domain.mission.repository;

import com.example.UMC_Spring.domain.member.entity.Member;
import com.example.UMC_Spring.domain.mission.entity.MemberMission;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface memberMissionRepo extends JpaRepository<MemberMission, Long> {

    @Query(value = "SELECT mm FROM MemberMission mm WHERE mm.member = :member",
            countQuery = "SELECT COUNT(mm) FROM MemberMission mm WHERE mm.member = :member")
    Page<MemberMission> findByMember(@Param("member") Member member, Pageable pageable);

    @Query(value = "SELECT mm FROM MemberMission mm WHERE mm.member = :member AND mm.isComplete = true",
            countQuery = "SELECT COUNT(mm) FROM MemberMission mm WHERE mm.member = :member AND mm.isComplete = true")
    Page<MemberMission> findCompletedByMember(@Param("member") Member member, Pageable pageable);

    @Query(value = "SELECT mm FROM MemberMission mm WHERE mm.member = :member AND mm.isComplete = false",
            countQuery = "SELECT COUNT(mm) FROM MemberMission mm WHERE mm.member = :member AND mm.isComplete = false")
    Page<MemberMission> findIncompleteByMember(@Param("member") Member member, Pageable pageable);

    @Query("SELECT COUNT(mm) FROM MemberMission mm WHERE mm.member = :member AND mm.isComplete = true")
    long countCompletedByMember(@Param("member") Member member);
}

