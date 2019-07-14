package com.myapplication.sell.exception;

import com.myapplication.sell.enums.ResultEnum;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-14 10:26
 * @Description:自定义异常
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
