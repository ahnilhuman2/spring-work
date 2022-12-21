package com.example.springwork;

import com.example.springwork.repository.JdbcMemberRepository;
import com.example.springwork.repository.JdbcTemplateMemberRepository;
import com.example.springwork.repository.MemberRepsoitory;
import com.example.springwork.repository.MemoryMemberRepository;
import com.example.springwork.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepsoitory memberRepository() {
// return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
