package com.ses.projectset.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ses.projectset.api.dto.MemberRequestDto.SignUpRequestDto;
import com.ses.projectset.domain.Member;
import com.ses.projectset.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberApi {
    private final MemberService memberService;

    @PostMapping("/signup")
    public boolean signUp(@RequestBody @Valid SignUpRequestDto dto) {
        Member member = Member.builder()
                .email(dto.email())
                .username(dto.username())
                .password(dto.password())
                .build();

        return memberService.signUp(member) != null;
    }
}
