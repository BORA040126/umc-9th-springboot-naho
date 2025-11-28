package com.example.UMC_Spring.domain.store.service;

import com.example.UMC_Spring.domain.mission.dto.MissionListDTO;
import org.springframework.data.repository.query.Param;

public interface MissionQueryService {
    MissionListDTO getMissionsByStore(@Param("storeId") Long storeId,int page);
}
