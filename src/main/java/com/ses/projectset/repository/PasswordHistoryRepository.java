package com.ses.projectset.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ses.projectset.domain.PasswordHistory;

public interface PasswordHistoryRepository extends JpaRepository<PasswordHistory, Long> {

}
