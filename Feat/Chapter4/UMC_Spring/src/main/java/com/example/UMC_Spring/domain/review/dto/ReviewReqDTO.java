package com.example.UMC_Spring.domain.review.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ReviewReqDTO {
    public record Create(
            @NotBlank
            String content,

            @Min(1) @Max(5)
            Float star

    ){}
}
