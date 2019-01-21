package com.lee.springsecurityloginremenber.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUser implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private int isAccountNonExpired=1;
    private int isAccountNonLocked=1;
    private int isCredentialsNonExpired=1;
    private int isNonEnabled=1;


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

    @Override
    public boolean isAccountNonExpired() {

        return isAccountNonExpired==1?true:false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonExpired==1?true:false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired==1?true:false;
    }

    @Override
    public boolean isEnabled() {
        return isNonEnabled==1?true:false;
    }
}
