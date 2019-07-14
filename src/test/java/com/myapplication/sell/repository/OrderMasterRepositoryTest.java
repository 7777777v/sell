package com.myapplication.sell.repository;

import com.myapplication.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-13 17:10
 * @Description:订单master测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository masterRepository;

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("12345678912");
        orderMaster.setBuyerAddress("西安市");
        orderMaster.setBuyerOpenId("110110");
        orderMaster.setOrderAmount(new BigDecimal(2.8));

        OrderMaster master = masterRepository.save(orderMaster);
        Assert.assertNotEquals(null,master);
    }

    @Test
    public void findByBuyerOpenId() {
        PageRequest request = PageRequest.of(0,2);
        Page<OrderMaster> orderMasters = masterRepository.findByBuyerOpenId("110110",request);
        System.out.println(orderMasters.getTotalElements());
    }
}