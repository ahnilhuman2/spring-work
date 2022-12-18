package com.example.springwork;

import com.example.springwork.repository.MemberRepsoitory;
import com.example.springwork.repository.MemoryMemberRepository;
import com.example.springwork.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepsoitory());
    }

    @Bean
    public MemberRepsoitory memberRepsoitory() {
        return new MemoryMemberRepository();
    }
}
