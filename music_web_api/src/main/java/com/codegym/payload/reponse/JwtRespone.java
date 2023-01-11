package com.codegym.payload.reponse;

import com.codegym.model.user.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtRespone {
    private String token;
    private Collection<? extends GrantedAuthority> roles;
    private User user;
    private String username;

    public JwtRespone(String token, Collection<? extends GrantedAuthority> roles, User user, String username) {
        this.token = token;
        this.roles = roles;
        this.user = user;
        this.username = username;
    }

    public JwtRespone() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
