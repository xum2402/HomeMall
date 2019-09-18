package com.mall.userservice.service;

import com.mall.userservice.bean.UserInfo;

public interface UserInfoService {
    /**
     * 通过id获取用户信息
     * @param id
     * @return
     */
    UserInfo getUserInfoById(Integer id);
}
