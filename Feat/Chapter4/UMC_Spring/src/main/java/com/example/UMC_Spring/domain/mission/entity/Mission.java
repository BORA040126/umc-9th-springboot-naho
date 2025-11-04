package com.example.UMC_Spring.domain.mission.entity;


import com.example.UMC_Spring.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name="mission")
public class Mission {
    //미션 아이디
    @Id
    @GeneratedValue
    private Long MissionId;

    //미션 기간
    @Column(name="deadline",nullable = false)
    private Date deadline;

    //미션조건
    @Column(name="conditional",nullable = false)
    private String conditional;

    //성공점수
    @Column(name="point",nullable = false)
    private int point;

    //생성일자
    @CreatedDate
    @Column(name="created_at",nullable = false, updatable = false)
    private LocalDateTime createdAt;

    //가게ID, 다대일 관계
    @ManyToOne
    @JoinColumn(name="store_id")
    private Store store;

}
