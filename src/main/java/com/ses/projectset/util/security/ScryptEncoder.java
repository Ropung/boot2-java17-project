package com.ses.projectset.util.security;

import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ScryptEncoder extends SCryptPasswordEncoder {

    private static final int DEFAULT_CPU_COST = 65536;

    private static final int DEFAULT_MEMORY_COST = 8;

    private static final int DEFAULT_PARALLELISM = 1;

    private static final int DEFAULT_KEY_LENGTH = 32;

    private static final int DEFAULT_SALT_LENGTH = 16;

    ScryptEncoder() {
        super(DEFAULT_CPU_COST, DEFAULT_MEMORY_COST, DEFAULT_PARALLELISM, DEFAULT_KEY_LENGTH, DEFAULT_SALT_LENGTH);
    }
}
