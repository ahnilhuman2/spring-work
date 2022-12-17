package com.example.springwork.repository;

import com.example.springwork.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepsoitory {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
