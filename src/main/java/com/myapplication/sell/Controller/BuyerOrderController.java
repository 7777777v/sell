package com.myapplication.sell.Controller;

import com.myapplication.sell.VO.ResultVo;
import com.myapplication.sell.converter.OrderForm2OrderDTOConverter;
import com.myapplication.sell.dto.OrderDTO;
import com.myapplication.sell.enums.ResultEnum;
import com.myapplication.sell.exception.SellException;
import com.myapplication.sell.form.OrderForm;
import com.myapplication.sell.service.BuyerService;
import com.myapplication.sell.service.OrderService;
import com.myapplication.sell.utils.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private BuyerService buyerService;

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
    @GetMapping("/list")
    public ResultVo<List<OrderDTO>> list(@RequestParam("openId") String openId,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size){
        if (StringUtils.isEmpty(openId)){
            log.error("【查询订单列表】 openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = PageRequest.of(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openId,request);
        return ResultVoUtil.success(orderDTOPage.getContent());
    }
    //订单详情
    @GetMapping("/detail")
    public ResultVo<OrderDTO> detail(@RequestParam("openId") String openId,
                                     @RequestParam("orderId") String orderId){
        OrderDTO orderDTO = buyerService.findOrderOne(openId, orderId);
        return ResultVoUtil.success(orderDTO);
    }

    //取消订单
    @PostMapping("/cancel")
    public ResultVo cancel(@RequestParam("openId") String openId,
                         @RequestParam("orderId") String orderId){
        buyerService.cancelOrder(openId, orderId);
        return ResultVoUtil.success();
    }
}
