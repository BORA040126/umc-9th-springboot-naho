package com.example.UMC_Spring.domain.mission.service;


import com.example.UMC_Spring.domain.mission.dto.MissionReqDTO;
import com.example.UMC_Spring.domain.mission.entity.Mission;
import com.example.UMC_Spring.domain.mission.repository.MissionRepo;
import com.example.UMC_Spring.domain.store.entity.Store;
import com.example.UMC_Spring.domain.store.exception.StoreException;
import com.example.UMC_Spring.domain.store.exception.code.StoreErrorCode;
import com.example.UMC_Spring.domain.store.repository.StoreRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepo missionRepo;
    private final StoreRepo storeRepo;
    public Long createMission(Long storeId, MissionReqDTO.Create dto)
    {
        Store store=storeRepo.findById(storeId)
                .orElseThrow(()->new StoreException(StoreErrorCode.NOT_FOUND));
        Mission mission=Mission.builder()
                .store(store)
                .deadline(dto.deadline())
                .conditional(dto.Conditional())
                .point(dto.point())
                .build();

        missionRepo.save(mission);
        return mission.getMissionId();
    }
}
