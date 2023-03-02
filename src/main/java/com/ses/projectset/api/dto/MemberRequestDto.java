package com.ses.projectset.api.dto;

// record: 불변성.
public record MemberRequestDto() {
    // inner class
    public record SignUpRequestDto(String username, String password, String email) {
    }
    
    public record SignInRequestDto(String username, String password) {
    }
}
