package com.ses.projectset.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

// record: 불변성.
public record MemberRequestDto() {
    // inner class
    public record SignUpRequestDto(
        @Length(min=3, max=5) String username,
        @Pattern(regexp = "^(?=.*[a-zA-Z])((?=.*\\d)(?=.*\\W)).{8,100}$") String password,
        @NotBlank String email
    ) {
    }
    
    public record SignInRequestDto(String username, String password) {
    }
}
