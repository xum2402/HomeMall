package com.mall.userservice.service.impl;

import com.mall.userservice.bean.UserInfo;
import com.mall.userservice.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("当前账号：{}",s);
        UserInfo userInfo = userInfoMapper.selectUserInfoByLoginName(s);
        if (userInfo == null){
            log.warn("该用户不存在:{}",s);
            throw new UsernameNotFoundException("账号不存在");
        }
        log.info("用户信息:{}",userInfo);
        return userInfo;

    }
}
