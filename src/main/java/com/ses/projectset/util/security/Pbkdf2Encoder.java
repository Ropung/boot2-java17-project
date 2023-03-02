package com.ses.projectset.util.security;

import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Pbkdf2Encoder extends Pbkdf2PasswordEncoder {
    Pbkdf2Encoder() {
        super();
        // secret: "key-file", saltLength: 16, costFactor: 12, SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA512
    }
}