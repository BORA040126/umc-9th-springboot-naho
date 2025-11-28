package com.example.UMC_Spring.domain.review.exception.code;


import com.example.UMC_Spring.global.apiPayload.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReviewSuccessCode implements BaseSuccessCode {
    OK(
            HttpStatus.OK,
            "REVIEW200",
            "리뷰가 성공적으로 수정되었습니다."
    )

    ;
    private final HttpStatus status;
    private final String code;
    private final String message;

}
