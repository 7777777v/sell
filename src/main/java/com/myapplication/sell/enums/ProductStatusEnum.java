package com.myapplication.sell.enums;

import lombok.Getter;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-13 13:33
 * @Description:商品状态
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;

    private String message;

    ProductStatusEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
