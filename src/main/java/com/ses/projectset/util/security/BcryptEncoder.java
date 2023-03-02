package com.ses.projectset.util.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BcryptEncoder extends BCryptPasswordEncoder {

    BcryptEncoder() {
        super(12);
    }
}
