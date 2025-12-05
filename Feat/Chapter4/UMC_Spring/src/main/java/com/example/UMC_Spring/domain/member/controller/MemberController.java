package com.example.UMC_Spring.domain.member.controller;

import com.example.UMC_Spring.domain.member.dto.MemberReqDTO;
import com.example.UMC_Spring.domain.member.dto.MemberResDTO;
import com.example.UMC_Spring.domain.member.exception.code.MemberSuccessCode;
import com.example.UMC_Spring.domain.member.service.command.MemberCommandService;
import com.example.UMC_Spring.domain.member.service.query.MemberQueryService;
import com.example.UMC_Spring.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;


    //회원가입
    @PostMapping("/sign-up")
    public ApiResponse<MemberResDTO.JoinDTO> signUp(
            @RequestBody @Valid MemberReqDTO.JoinDTO dto
    )
    {
        return ApiResponse.onSuccessWithData(MemberSuccessCode.FOUND,memberCommandService.signup(dto));
    }

    //로그인
    @PostMapping("/login")
    public ApiResponse<MemberResDTO.LoginDTO> login(
            @RequestBody @Valid MemberReqDTO.LoginDTO dto
    ){
        return ApiResponse.onSuccessWithData(MemberSuccessCode.FOUND,memberQueryService.login(dto));
    }

}
