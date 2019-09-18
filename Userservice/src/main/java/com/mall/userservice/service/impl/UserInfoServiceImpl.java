package com.mall.userservice.service.impl;

import com.mall.userservice.bean.UserInfo;
import com.mall.userservice.mapper.UserInfoMapper;
import com.mall.userservice.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfoById(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }
}
