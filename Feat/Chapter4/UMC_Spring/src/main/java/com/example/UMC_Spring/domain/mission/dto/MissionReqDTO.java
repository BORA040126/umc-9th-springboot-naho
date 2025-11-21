package com.example.UMC_Spring.domain.mission.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Date;

public class MissionReqDTO {
    public record Create(
            @NotBlank
            Date deadline,

            @NotBlank
            String Conditional,

            @NotBlank
            int point

            ){


    }
}
