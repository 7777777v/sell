package com.myapplication.sell.enums;

import lombok.Getter;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-13 16:34
 * @Description:订单状态枚举
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消")
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

}
