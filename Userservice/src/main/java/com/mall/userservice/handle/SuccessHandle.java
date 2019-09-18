package com.mall.userservice.handle;


import com.mall.userservice.bean.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 安全框架验证成功处理器
 */
@Slf4j
@Component
public class SuccessHandle implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //获取异步请求标识
        String header = httpServletRequest.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(header)){
            //响应json
            httpServletResponse.setCharacterEncoding("utf-8");
            httpServletResponse.setContentType("application/json;charset=utf-8");
            PrintWriter writer = httpServletResponse.getWriter();
            writer.append(JsonResult.success("登录成功").toString());
            writer.close();

        }else {
            httpServletResponse.sendRedirect("/");
        }
    }
}
