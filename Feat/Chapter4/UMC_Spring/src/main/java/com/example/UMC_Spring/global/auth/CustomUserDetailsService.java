package com.example.UMC_Spring.global.auth;


import com.example.UMC_Spring.domain.member.entity.Member;
import com.example.UMC_Spring.domain.member.exception.MemberException;
import com.example.UMC_Spring.domain.member.exception.code.MemberErrorCode;
import com.example.UMC_Spring.domain.member.repository.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepo memberRepo;

    @Override
    public UserDetails loadUserByUsername(
            String username
    ) throws UsernameNotFoundException{
        Member member = memberRepo.findByEmail(username)
                .orElseThrow(()->new MemberException(MemberErrorCode.NOT_FOUND));
        return new CustomUserDetails(member);
    }
}
