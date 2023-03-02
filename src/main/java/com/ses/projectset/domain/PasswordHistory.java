package com.ses.projectset.domain;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.ZoneId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(
        // uniqueConstraints = {
        //         @UniqueConstraint(name="uq_member_email", columnNames = "email")
        // },
        name = "member_password_history",
        indexes = {
                @Index(name="idx_member_password_history_tuple", columnList = "digest, memberId", unique = false)
        }
)
public class PasswordHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(nullable = false)
    private Long memberId;

    @Column(length = 256, nullable = false)
    private String digest;

    @Column
    @Builder.Default
    private OffsetDateTime createdAt = OffsetDateTime.now(ZoneId.of("Asia/Seoul"));
}