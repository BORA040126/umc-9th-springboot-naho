package com.example.UMC_Spring.global.auth.jwt;

import com.example.UMC_Spring.global.apiPayload.ApiResponse;
import com.example.UMC_Spring.global.apiPayload.code.GeneralErrorCode;
import com.example.UMC_Spring.global.auth.CustomUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
            ) throws ServletException, IOException{
//        try{
//            String token = request.getHeader("Authorization");
//            if(token==null || !token.startsWith("Bearer ")){
//                filterChain.doFilter(request,response);
//                return;
//            }
//            token=token.replace("Bearer ","");
//            if(jwtUtil.isValid(token)){
//                String email=jwtUtil.getEmail(token);
//                UserDetails user = customUserDetailsService.loadUserByUsername(email);
//                Authentication auth = new UsernamePasswordAuthenticationToken(user,
//                        null,
//                        user.getAuthorities());
//                SecurityContextHolder.getContext().setAuthentication(auth);
//            }
//            filterChain.doFilter(request,response);
//        } catch(Exception e){
//            response.setContentType("application/json;charset=utf-8");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//
//            ApiResponse<Void> errorResponse = ApiResponse.onFailure(GeneralErrorCode.UNAUTHORIZED,null);
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.writeValue(response.getOutputStream(),errorResponse);
//
//        }
        String token = request.getHeader("Authorization");

        if (token == null || !token.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        token = token.replace("Bearer ", "");

        if (jwtUtil.isValid(token)) {

            String email = jwtUtil.getEmail(token);
            UserDetails user = customUserDetailsService.loadUserByUsername(email);
            Authentication auth = new UsernamePasswordAuthenticationToken(
                    user,
                    null,
                    user.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);
    }


}
