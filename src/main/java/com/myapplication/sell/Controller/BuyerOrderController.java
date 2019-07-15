package com.myapplication.sell.Controller;

import com.myapplication.sell.VO.ResultVo;
import com.myapplication.sell.converter.OrderForm2OrderDTOConverter;
import com.myapplication.sell.dto.OrderDTO;
import com.myapplication.sell.enums.ResultEnum;
import com.myapplication.sell.exception.SellException;
import com.myapplication.sell.form.OrderForm;
import com.myapplication.sell.service.OrderService;
import com.myapplication.sell.utils.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-15 22:31
 * @Description:买家订单Controller
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    //创建订单
    @PostMapping("/create")
    public ResultVo<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】 参数不正确， orderForm = {}" , orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);

        Map<String ,String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return ResultVoUtil.success(map);
    }


    //订单列表

    //

}
