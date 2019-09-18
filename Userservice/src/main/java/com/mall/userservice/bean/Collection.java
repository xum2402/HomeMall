package com.mall.userservice.bean;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * tb_collection
 * @author 
 */

@Data
@Table(name = "tb_collection")
public class Collection implements Serializable {
    /**
     * 主键
     */
    @Id
    private Integer collectionId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 商品ID
     */
    private String goodsId;


}