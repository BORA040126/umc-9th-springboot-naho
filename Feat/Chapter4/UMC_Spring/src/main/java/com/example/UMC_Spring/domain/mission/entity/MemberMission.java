package com.example.UMC_Spring.domain.mission.entity;

import com.example.UMC_Spring.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="member_mission")
public class MemberMission {

    //MemberMissionID 자동생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // 다대일 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    // 다대일 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    //성공여부, BOOLEAN 사용
    @Column(nullable = false)
    private boolean isComplete = false;



}
