package com.ses.projectset.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


// record: 불변성.
public record MemberRequestDto() {

    public record SignUpRequestDto(
        @NotBlank String username,
        @Pattern(regexp = "^(?=.*[a-zA-Z])((?=.*\\d)(?=.*\\W)).{8,100}$") String password,
        @NotBlank String email
    ) {
    }
    
    public record SignInRequestDto(String username, String password) {
    }
}
