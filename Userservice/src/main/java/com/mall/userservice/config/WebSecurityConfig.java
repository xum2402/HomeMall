package com.mall.userservice.config;

import com.mall.userservice.handle.FailureHandle;
import com.mall.userservice.handle.SuccessHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SuccessHandle successHandle;

    @Autowired
    private FailureHandle failureHandle;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //放行请求
                .antMatchers("/user/login").permitAll()
                //所有请求都需要登录过访问
                .anyRequest().authenticated()
                //表单登录
                .and()
                .formLogin()
                //登录页面地址
                .loginPage("/user/login")
                //登录请求地址
                .loginProcessingUrl("/user/login")
//              .defaultSuccessUrl("https://www.baidu.com");
                //设置登录成功响应处理器
                .successHandler(successHandle)
                .failureHandler(failureHandle);
        //关闭CSRF跨域
        http.csrf().disable();
    }

    /**
     * 放行静态资源
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/res/**");
    }

    /**
     * 密码处理器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
