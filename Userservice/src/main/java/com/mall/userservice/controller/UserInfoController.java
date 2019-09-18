package com.mall.userservice.controller;

import com.mall.userservice.bean.UserInfo;
import com.mall.userservice.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("/login")
    public String loginPage(){
        return "user/login";
    }

    @ResponseBody
    @RequestMapping("/id/{id}")
    public UserInfo getUserInfo(@PathVariable Integer id){
        return userInfoService.getUserInfoById(id);
    }
}
