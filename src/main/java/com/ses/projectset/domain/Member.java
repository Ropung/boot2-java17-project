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
        indexes = {
                @Index(name="udx_member_username", columnList = "username", unique = true)
        }
)
public class Member implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(length = 50, nullable = false)
    private String username; // username => username     user_name  => userName

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 355, nullable = false)
    private String email;

    @Column
    @Builder.Default
    private OffsetDateTime createdAt = OffsetDateTime.now(ZoneId.of("Asia/Seoul"));
    
    @Column
    private OffsetDateTime lastLogin;
}