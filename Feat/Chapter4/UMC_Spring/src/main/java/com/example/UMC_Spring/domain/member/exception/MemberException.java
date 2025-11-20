package com.example.UMC_Spring.domain.member.exception;

import com.example.UMC_Spring.global.apiPayload.code.BaseErrorCode;
import com.example.UMC_Spring.global.apiPayload.exception.GeneralException;

public class MemberException extends GeneralException {
    public MemberException(BaseErrorCode code) {
        super(code);
    }
}
