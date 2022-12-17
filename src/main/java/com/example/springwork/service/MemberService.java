package com.example.springwork.service;

import com.example.springwork.domain.Member;
import com.example.springwork.repository.MemberRepsoitory;
import com.example.springwork.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    public MemberService(MemberRepsoitory memberRepsoitory) {
        this.memberRepsoitory = memberRepsoitory;
    }

    private final MemberRepsoitory memberRepsoitory;

    //회원가입
    public Long join(Member member) {
        // 같은 이름이 있는 중복회원X
        validateDuplicateMember(member); // 중복회원검증
        memberRepsoitory.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepsoitory.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
        });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepsoitory.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepsoitory.findById(memberId);
    }
}
