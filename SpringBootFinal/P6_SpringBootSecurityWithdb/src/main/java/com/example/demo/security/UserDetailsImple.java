package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entities.User;

public class UserDetailsImple implements UserDetails {

    int uid;
    String username;
    String password;
    List<GrantedAuthority> authorities;
    boolean status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // 🔴 IMPORTANT METHODS
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status;
    }

    public UserDetailsImple() {
        super();
    }

    public UserDetailsImple(int uid, String username, String password,
                            List<GrantedAuthority> authorities, boolean status) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.status = status;
    }

    public static UserDetails build(User u) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(u.getRoles()));
        return new UserDetailsImple(
                u.getUid(),
                u.getUsername(),
                u.getPassword(),
                authorities,
                u.isStatus()
        );
    }
}
