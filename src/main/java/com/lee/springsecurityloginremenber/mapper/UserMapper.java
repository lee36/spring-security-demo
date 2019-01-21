package com.lee.springsecurityloginremenber.mapper;

import com.lee.springsecurityloginremenber.model.MyUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

public interface UserMapper {
   @Insert("insert into user_tb(username,password,is_non_expired,is_non_locked,is_non_enable,is_non_credentials_expired) values(#{username},#{password},1,1,1,1)")
   public int addUser(MyUser user);
   @Select("select * from user_tb where username=#{username}")
   public MyUser getUserByUsername(String username);
}
