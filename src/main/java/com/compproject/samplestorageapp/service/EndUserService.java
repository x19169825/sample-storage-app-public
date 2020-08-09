package com.compproject.samplestorageapp.service;

import com.compproject.samplestorageapp.model.users.EndUser;
import lombok.SneakyThrows;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;


public class EndUserService implements UserDetails {

    private final EndUser endUser;

    public EndUserService(EndUser endUser) {
        this.endUser = endUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(endUser.getRole()));
    }

    //Getters and Setters not included for brevity

    @Override
    public String getPassword() {
        return endUser.getPassword();
    }

    @Override
    public String getUsername() {
        return endUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @SneakyThrows
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
        return true;
    }
}
