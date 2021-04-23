package com.ildong.springdatajpa.repository;

import com.ildong.springdatajpa.entity.Member;
import com.ildong.springdatajpa.entity.UsernameOnlyDto;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
    public void myTest(){
        String a = " ";
        String b = "";
        String c = null;
        String d = "text";
        assertThat(StringUtils.hasText(a)).isFalse();
        assertThat(StringUtils.hasText(b)).isFalse();
        assertThat(StringUtils.hasText(c)).isFalse();
        assertThat(StringUtils.hasText(d)).isTrue();
    }

    @Test
    public void testMember(){
        Member member = new Member("memberA",10);
        Member savedMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(savedMember.getId()).get();

        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    public void paging(){
        for(int i=0;i<37;i++){
            Member member = new Member("member_"+i,i+10);
            memberRepository.save(member);
        }
        memberRepository.flush();
        PageRequest pageRequest = PageRequest.of(1,10, Sort.by(Sort.Direction.ASC,"id"));
        System.out.println("========================");
        Page<Member> pageAge = memberRepository.findByAgeGreaterThan(20, pageRequest);
        Page<Member> pageAll = memberRepository.findAll(pageRequest);
        System.out.println("========================");
        List<Member> contentAge = pageAge.getContent();

        System.out.println("page.getTotalPages() : " + pageAge.getTotalPages());
        System.out.println("page.getTotalElements() : " + pageAge.getTotalElements());

        List<Member> contentAll = pageAll.getContent();

        System.out.println("pageAll.getTotalPages() : " + pageAll.getTotalPages());
        System.out.println("pageAll.getTotalElements() : " + pageAll.getTotalElements());
    }

    @Test
    public void dirtyChecking(){
        Member member1 = new Member("memberA", 20);
        Member member2 = new Member("memberA", 20);
        Member member3 = new Member("memberA", 20);
        Member member4 = new Member("memberA", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
        List<UsernameOnlyDto> result = memberRepository.findProjectionsByUsername("memberA");
        for (UsernameOnlyDto usernameOnlyDto : result) {
            System.out.println("usernameOnlyDto.getUsername() = " + usernameOnlyDto.getUsername());
        }
    }
}