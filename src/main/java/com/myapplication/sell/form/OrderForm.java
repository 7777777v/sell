package com.myapplication.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-15 22:34
 * @Description:订单表单验证
 */
@Data
public class OrderForm {

    /** 买家姓名 */
    @NotEmpty(message = "姓名必填")
    private String name;

    /** 买家手机号 */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /** 买家联系地址 */
    @NotEmpty(message = "地址必填")
    private String address;

    /** 买家openid */
    @NotEmpty(message = "openId必填")
    private String openId;

    /** 买家购物车 */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
