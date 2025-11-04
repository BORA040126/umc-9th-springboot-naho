package com.example.UMC_Spring.domain.store.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="location")
public class Location {

    //지역 ID
    @Id
    @GeneratedValue
    private Long locationId;

    //지역명
    @Column(name="name",nullable = false)
    private String name;



}
