package com.myapplication.sell.enums;

import lombok.Getter;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-14 10:27
 * @Description:提示消息
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存不正确")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
