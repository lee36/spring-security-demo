package com.lee.springsecurityloginremenber.controller;

import com.lee.springsecurityloginremenber.mapper.UserMapper;
import com.lee.springsecurityloginremenber.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder encoder;
    @RequestMapping("/register")
    public Object register(String username,String password){
        String newPass = encoder.encode(password);
        MyUser user = new MyUser();
        user.setUsername(username);
        user.setPassword(newPass);
        int i = userMapper.addUser(user);
        return i;
    }
    @RequestMapping("/index")
    public Object index(){
        return "index";
    }
}
