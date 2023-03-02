package com.ses.projectset.util.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EncoderFactory {
    private final BcryptEncoder bcryptEncoder;
    private final ScryptEncoder scryptEncoder;
    private final Pbkdf2Encoder pbkdf2Encoder;
    
    public enum EncoderType {
        BCRYPT,
        PBKDF2,
        SCRYPT;
    }
    
    public PasswordEncoder defaultEncoder() {
        return createEncoder(EncoderType.valueOf("BCRYPT"));
    }

    public PasswordEncoder createEncoder(EncoderType encoder) {
        return switch(encoder) {
            case BCRYPT -> bcryptEncoder;
            case PBKDF2 -> scryptEncoder;
            case SCRYPT -> pbkdf2Encoder;
        };
    }
}
