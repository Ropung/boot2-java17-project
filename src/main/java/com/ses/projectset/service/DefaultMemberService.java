package com.ses.projectset.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ses.projectset.domain.Member;
import com.ses.projectset.domain.PasswordHistory;
import com.ses.projectset.repository.MemberRepository;
import com.ses.projectset.repository.PasswordHistoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultMemberService implements MemberService {
    // final이 있어야 @RequiredArgsConstructor에 의해서 주입됨.
    private final MemberRepository memberRepository;
    private final PasswordHistoryRepository historyRepository;
    private final PasswordEncoder passwordEncoder;

    // password: 영문, 숫자, 특수문자 모두 포함 8자 이상 최대 100글자 정도

    @Override
    public Member signUp(Member member) {
        String rawPassword = member.getPassword();
        // digest <- 해싱된 값: 해싱은 단방향 암호화
        // 해싱: 복호화 개념이 없는. 근데 레인보우 테이블이라는 건 있고
        // 그건 일종의 답안지 역할
        // 그걸 기존 답안지 유효하지 않게 하려고 넣는 게 salt
        // password -> (hashing) -> digest
        // password + salt -> (hashing) -> digest

        // BCrypt
        // - salt 랜덤 생성(같은 비밀번호를 해싱하더라도 서로 다른 salt 때문에 서로 다른 digest): 레인보우 테이블 만들기 어려워짐.
        // - 반복 해싱: 몇 회 반복했는지는 외부에는 비밀. 우리는 아까 넣은 12회. 8회만 돼도 미친듯이 안전.
        // 해커가 이거 뚫으려면 세상에서 가장 좋은 양자컴 60년 돌리면 됨. 비밀번호 하나 획득.
        // - 보존할 때 salt 포함 보존
        // 비밀번호 보존할 때 salt를 구분해서 따로 보존할 필요가 없음. digest 통째로 보존하면 salt도 password도 다 보존되는 상태.
        String digest = passwordEncoder.encode(rawPassword);
        // passwordEncoder.matches(rawPassword, digest);
        
        member.setPassword(digest);
        Member joinMember = memberRepository.save(member);

        PasswordHistory passwordHistory = PasswordHistory.builder()
                .memberId(joinMember.getId())
                .digest(digest)
                .build();

        // Login 등 암호 비교할 때:
        // if (!passwordEncoder.matches(rawPassword, digest)) {
        //     // throw new IllegalStateException("비밀번호 불일치");
        // }

        historyRepository.save(passwordHistory);

        return joinMember;
    }
}
