package com.myapplication.sell.service;

import com.myapplication.sell.dto.OrderDTO;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-17 22:04
 * @Description:买家service
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openId,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openId,String orderId);
}
