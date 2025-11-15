package com.example.UMC_Spring.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode {


    OK(HttpStatus.OK, "COMMON200_1", "요청이 성공적으로 처리되었습니다."),
    CREATED(HttpStatus.CREATED, "COMMON201_1", "리소스가 성공적으로 생성되었습니다."),
    REVIEW_FETCH_SUCCESS(HttpStatus.OK, "REVIEW200_1", "리뷰가 성공적으로 조회되었습니다."),
    REVIEW_CREATE_SUCCESS(HttpStatus.CREATED, "REVIEW201_1", "리뷰가 성공적으로 등록되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}

