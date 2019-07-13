package com.myapplication.sell.enums;

import lombok.Getter;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-13 16:37
 * @Description:支付状态枚举
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功")
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
