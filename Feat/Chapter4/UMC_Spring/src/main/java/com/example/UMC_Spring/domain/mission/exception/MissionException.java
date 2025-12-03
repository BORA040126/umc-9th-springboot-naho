package com.example.UMC_Spring.domain.mission.exception;

import com.example.UMC_Spring.global.apiPayload.code.BaseErrorCode;
import com.example.UMC_Spring.global.apiPayload.exception.GeneralException;
import org.springframework.http.HttpStatus;

public class MissionException extends GeneralException{
    public  MissionException(BaseErrorCode code){super(code);}}
