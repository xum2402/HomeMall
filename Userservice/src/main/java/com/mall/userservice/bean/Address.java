package com.mall.userservice.bean;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * tb_address
 * @author 
 */

@Data
@Table(name = "tb_address")
public class Address implements Serializable {
    /**
     * 主键
     */
    @Id
    private Integer addressId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 收货人姓名
     */
    private String consignee;

    /**
     * 收货地址
     */
    private String receivingAddress;

    /**
     * 联系方式
     */
    private Long contactInformation;

    /**
     * 默认
     */
    private Boolean defaulted;

}