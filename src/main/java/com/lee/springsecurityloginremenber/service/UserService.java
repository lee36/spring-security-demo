package com.lee.springsecurityloginremenber.service;

import com.lee.springsecurityloginremenber.mapper.UserMapper;
import com.lee.springsecurityloginremenber.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = userMapper.getUserByUsername(username);
        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList("user,admin"));
        return user;
    }
}
