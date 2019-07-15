package com.myapplication.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myapplication.sell.dataobject.OrderDetail;
import com.myapplication.sell.dto.OrderDTO;
import com.myapplication.sell.enums.ResultEnum;
import com.myapplication.sell.exception.SellException;
import com.myapplication.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-15 22:48
 * @Description:orderForm转换OrderDTO
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenId(orderForm.getOpenId());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try{
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("【对象转换】 错误 , String = {}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
