package com.example.UMC_Spring.domain.mission.service;


import com.example.UMC_Spring.domain.mission.converter.MissionConverter;
import com.example.UMC_Spring.domain.mission.dto.MissionListDTO;
import com.example.UMC_Spring.domain.mission.entity.Mission;
import com.example.UMC_Spring.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;

    @Override
    public MissionListDTO getMissionsByStore(Long storeId,int page){
        int pageIndex=page-1;

        Pageable pageable= PageRequest.of(pageIndex,10, Sort.Direction.DESC,"createdAt");

        Page<Mission> missionPage=missionRepository.findMissionsByStore(storeId,pageable);

        return MissionConverter.toMissionListDTO(missionPage);

    }
}
