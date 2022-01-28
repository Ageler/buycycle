package com.andrewborchenko.spring.buycycle.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        // возвращаем роль в строковом виде
        return name();
    }
}
