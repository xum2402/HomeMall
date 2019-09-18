package com.mall.userservice;

import com.mall.userservice.bean.UserInfo;
import com.mall.userservice.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserserviceApplicationTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Test
    public void contextLoads() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserPhone(18280122402L);
        //设置密码并加秘
        userInfo.setUserPassword(passwordEncoder.encode("123"));
        userInfo.setUserNickName("xum");
        int i = userInfoMapper.insertSelective(userInfo);
        log.info("添加成功:{}",i);
    }

}
