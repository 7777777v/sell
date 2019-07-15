package com.myapplication.sell.converter;

import com.myapplication.sell.dataobject.OrderMaster;
import com.myapplication.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-14 15:44
 * @Description:orderMaster转为orderDTO
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        List<OrderDTO> orderDTOList =
                orderMasterList
                        .stream()
                        .map(e -> convert(e)).collect(Collectors.toList());
        return orderDTOList;
    }
}
