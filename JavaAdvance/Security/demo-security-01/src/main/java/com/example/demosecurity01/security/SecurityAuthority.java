package com.example.demosecurity01.security;

import com.example.demosecurity01.entity.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {
    private final Role role;
    @Override
    public String getAuthority() {
        return role.getName();
    }
}
