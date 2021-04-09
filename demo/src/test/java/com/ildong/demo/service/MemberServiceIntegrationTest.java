package com.ildong.demo.service;

import com.ildong.demo.domain.Member;
import com.ildong.demo.repository.MemberRepository;
import com.ildong.demo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    // test는 편하게 가자~
    @Autowired MemberService memberService;
    //@Autowired MemoryMemberRepository memberRepository;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setName("hello");
        //When
        Long saveId = memberService.join(member);
        //Then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        //Given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");
        
        //When
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));//예외가 발생해야 한다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    public void test(){
        List<String> list = Arrays.asList("abc","aaa","bbb","ddd","aaa","aaaa","bbbb");
        System.out.println("list : "+list);
        Collections.sort(list,(s1,s2) -> s2.compareTo(s1));
        System.out.println("list desc : "+list);
        Collections.sort(list,(s1,s2) -> s1.compareTo(s2));
        System.out.println("list asc : "+list);
        System.out.println("stream : "+list.stream());
        System.out.println("stream filter : "+list.stream().filter(s1 -> s1.length() == 3));
        System.out.println("stream filter findAny : "+list.stream().filter(s1 -> s1.length() == 4).findAny());
        System.out.println(list.stream().filter(s1 -> s1.length() == 4).findAny() instanceof Optional);
        System.out.println(list.stream().filter(s1 -> s1.length() == 4).findAny().getClass());
        System.out.println(list.getClass());

        assertEquals(1,1);
    }
}