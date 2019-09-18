package com.mall.userservice.mapper;


import com.mall.userservice.bean.UserInfo;
import tk.mybatis.mapper.common.Mapper;

public interface UserInfoMapper extends Mapper<UserInfo> {

    UserInfo selectUserInfoByLoginName(String loginName);
}