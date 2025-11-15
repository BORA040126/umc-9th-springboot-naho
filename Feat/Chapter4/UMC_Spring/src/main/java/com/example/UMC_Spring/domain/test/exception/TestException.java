package com.example.UMC_Spring.domain.test.exception;

import com.example.UMC_Spring.global.apiPayload.code.BaseErrorCode;
import com.example.UMC_Spring.global.apiPayload.exception.GeneralException;

public class TestException extends GeneralException {
    public TestException(BaseErrorCode code) {
        super(code);
    }
}
