package com.example.UMC_Spring.global.auth.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @GetMapping("/login")
    public Map<String, Object> login(@RequestParam(required = false) String logout) {
        Map<String, Object> response = new HashMap<>();

        if (logout != null) {
            response.put("message", "로그아웃이 성공적으로 처리되었습니다.");
        } else {
            response.put("message", "로그인이 필요한 페이지입니다.");
        }

        return response;
    }
}
