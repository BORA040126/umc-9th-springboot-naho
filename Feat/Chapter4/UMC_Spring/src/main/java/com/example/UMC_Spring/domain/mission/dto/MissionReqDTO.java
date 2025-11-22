package com.example.UMC_Spring.domain.mission.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Date;

public class MissionReqDTO {
    public record MissionCreate(
            Date deadline,
            String conditional,
            int point

            ){


    }
}
