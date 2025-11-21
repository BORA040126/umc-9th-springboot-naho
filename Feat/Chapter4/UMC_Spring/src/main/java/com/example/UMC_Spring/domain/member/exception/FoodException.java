package com.example.UMC_Spring.domain.member.exception;

import com.example.UMC_Spring.domain.member.exception.code.FoodErrorCode;
import com.example.UMC_Spring.global.apiPayload.code.BaseErrorCode;
import com.example.UMC_Spring.global.apiPayload.exception.GeneralException;

public class FoodException extends GeneralException {
    public FoodException(BaseErrorCode code) {
        super(code);
    }
}
