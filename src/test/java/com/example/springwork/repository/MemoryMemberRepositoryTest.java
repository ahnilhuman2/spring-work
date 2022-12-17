package com.example.springwork.repository;

import com.example.springwork.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repsoitory = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repsoitory.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repsoitory.save(member);

        Member result = repsoitory.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repsoitory.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repsoitory.save(member2);

        Member result = repsoitory.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repsoitory.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repsoitory.save(member2);

        List<Member> result = repsoitory.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
