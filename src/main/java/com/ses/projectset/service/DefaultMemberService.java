package com.ses.projectset.service;

import org.springframework.stereotype.Service;

import com.ses.projectset.domain.Member;
import com.ses.projectset.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultMemberService implements MemberService {
    // final이 있어야 @RequiredArgsConstructor에 의해서 주입됨.
    private final MemberRepository memberRepository;

    @Override
    public Member signUp(Member member) {
        // TODO 비밀번호 해싱
        return memberRepository.save(member);
    }
}
