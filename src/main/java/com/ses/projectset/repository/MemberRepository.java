package com.ses.projectset.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ses.projectset.domain.Member;

// 제네릭:
//      Member 엔티티(= 테이블이랑 같은 형태를 띤 애)에 대해서 사용
//      id는 Long 타입
public interface MemberRepository extends JpaRepository<Member, Long> {
    
}
