package com.example.UMC_Spring.domain.store.exception;

import com.example.UMC_Spring.domain.store.exception.code.StoreErrorCode;
import com.example.UMC_Spring.global.apiPayload.code.BaseErrorCode;
import com.example.UMC_Spring.global.apiPayload.exception.GeneralException;

public class StoreException extends GeneralException {
    public StoreException(BaseErrorCode code) {
        super(code);
    }
}
