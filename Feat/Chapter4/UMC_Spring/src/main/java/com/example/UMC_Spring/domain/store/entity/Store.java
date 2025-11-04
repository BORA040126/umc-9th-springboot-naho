package com.example.UMC_Spring.domain.store.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="store")
public class Store {
    //storeID 자동생성
    @Id
    @GeneratedValue
    private Long storeId;

    //가게명
    @Column(name="name",nullable = false)
    private String name;

    //사장님 구분번호
    @Column(name="manager_number",nullable = false)
    private Long managerNumber;

    //상세주소(없을 수도 있음)
    @Column(name="detail_address")
    private String detailAddress;


    // 다대일 관계, 지역 ID
    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;

}
