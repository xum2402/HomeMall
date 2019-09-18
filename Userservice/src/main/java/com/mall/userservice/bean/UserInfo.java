package com.mall.userservice.bean;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * tb_user_info
 * @author 
 */

@Data
@Table(name = "tb_user_info")
public class UserInfo implements Serializable, UserDetails {
    /**
     * 用户主键
     */
    @Id
    private Long userId;

    /**
     * 手机号
     */
    private Long userPhone;

    /**
     * 昵称
     */
    private String userNickName;

    /**
     * 密码
     */
    private String userPassword;
    /**
     * 头像地址
     */
    private String userAvatar;

    /**
     * 积分
     */
    private Integer userIntegral;

    /**
     * 注册时间
     */
    private Date userRegisterTime;

    /**
     * 最后一次登录时间
     */
    private Date userLastLoginTime;

    /**
     * 最后一次登录地址
     */
    private String userLastLoginAddress;

    /**
     * 启用状态 0 启用 1禁用
     */
    private Boolean userEnable;


    /**
     * 权限集合
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List authorities = new ArrayList();
        authorities.add(new SimpleGrantedAuthority("ROLE_user"));


        return authorities;
    }

    /**
     * 密码
     * @return
     */
    @Override
    public String getPassword() {
        return userPassword;
    }

    /**
     * 用户名
     * @return
     */
    @Override
    public String getUsername() {
        return userNickName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账号是否锁定
     * @return
     */
    @Override
    public boolean isEnabled() {
        return userEnable;
    }
}