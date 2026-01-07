package com.hrms.service;

import com.hrms.model.Role;
import org.springframework.stereotype.Component;

@Component
public class AuthContext {

    // TEMP: simulate logged-in user role
    private Role currentRole = Role.USER;

    public Role getCurrentRole() {
        return currentRole;
    }

    public void setCurrentRole(Role role) {
        this.currentRole = role;
    }

    public boolean isAdmin() {
        return currentRole == Role.ADMIN;
    }
}
