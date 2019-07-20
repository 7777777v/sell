package com.myapplication.sell.service.impl;

import com.myapplication.sell.dto.OrderDTO;
import com.myapplication.sell.enums.ResultEnum;
import com.myapplication.sell.exception.SellException;
import com.myapplication.sell.service.BuyerService;
import com.myapplication.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-17 22:17
 * @Description:买家service实现
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openId, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openId, orderId);
        return orderDTO;
    }

    @Override
    public OrderDTO cancelOrder(String openId, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openId, orderId);
        if (orderDTO == null){
            log.error("【取消订单】 查不到该订单，orderId = {}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openId,String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null){
            return null;
        }
        //判断是否是自己的订单
        if (!orderDTO.getBuyerOpenId().equalsIgnoreCase(openId)){
            log.error("【查询订单】 订单的openId不一致. openId = {},orderDTO = {}",openId,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
