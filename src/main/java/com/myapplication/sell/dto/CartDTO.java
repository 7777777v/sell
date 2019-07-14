package com.myapplication.sell.dto;

import lombok.Data;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-14 11:12
 * @Description:购物车
 */
@Data
public class CartDTO {

    /** 商品id */
    private String productId;

    /** 商品数量 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
