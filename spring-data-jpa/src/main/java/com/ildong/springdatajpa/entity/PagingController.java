package com.ildong.springdatajpa.entity;

import com.ildong.springdatajpa.repository.MemberRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PagingController {

    private final MemberRepository memberRepository;

    @GetMapping("/members")
    public List<MemberDto> list(/* @PageableDefault(size=,sort="") */ Pageable pageable){
        // parameter 로 page / size 받아올수있음
        // yml 에서 컨트롤가능
        Page<Member> page = memberRepository.findAll(pageable);


//        return page.map(member -> new MemberDto(member)).getContent();
        return page.map(MemberDto::new).getContent();
//        return page.stream().map(MemberDto::new).collect(Collectors.toList());
    }

    static class MemberDto {
        private Long userId;
        private String userName;
        private int age;

        public MemberDto(Long userId, String userName, int age) {
            this.userId = userId;
            this.userName = userName;
            this.age = age;
        }

        public MemberDto(Member m){
            this.userId = m.getId();
            this.userName = m.getUsername();
            this.age = m.getAge();
        }
    }
}
