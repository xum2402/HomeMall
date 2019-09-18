package com.mall.userservice.handle;

import com.mall.userservice.bean.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 失败处理器
 * @author 86182
 */
@Slf4j
@Component
public class FailureHandle implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        log.warn("登录失败,{}",e.getMessage());
        //获取异步请求标识
        String header = httpServletRequest.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(header)){

            httpServletResponse.setCharacterEncoding("utf-8");
            httpServletResponse.setContentType("application/json;charset=utf-8");
            PrintWriter writer = httpServletResponse.getWriter();

            if (e instanceof UsernameNotFoundException){
                writer.append(JsonResult.error("该用户名不存在").toString());

            }else {
                writer.append(JsonResult.error("用户名或密码错误").toString());
            }
            writer.close();

        }else {
            httpServletResponse.sendRedirect("/user/login");
        }
    }
}
