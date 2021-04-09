package com.ildong.demo;

import com.ildong.demo.aop.TimeTraceAop;
import com.ildong.demo.domain.Member;
import com.ildong.demo.repository.*;
import com.ildong.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    /**
     * case 1
     * */
//    @Autowired
//    private DataSource dataSource;
    /**
     * case 1 end
     * */


    /**
     * case 2
     * */
//    private DataSource dataSource;
//    @Autowired
//    public SpringConfig(DataSource dataSource){ this.dataSource = dataSource; }
    /**
     * case 2 end
     * */


    /**
     * case 3
     * */
//    private EntityManager em;
//    @Autowired
//    public SpringConfig(EntityManager em){ this.em = em; }
    /**
     * case 3 end
     * */


    /**
     * case 4
     * */
    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository){ this.memberRepository = memberRepository; }
    /**
     * case 4 end
     * */
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    //TimeTraceAop 에서 Component 할수있지만 여기에 등록해주면 특별해보임ㅋㅋ
//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }

//    전체주석 case 4
//    @Bean
//    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);  // case 1,2
        //return new JpaMemberRepository(em);    // case 3
//    }
}
