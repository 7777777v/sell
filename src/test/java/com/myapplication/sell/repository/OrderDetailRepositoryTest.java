package com.myapplication.sell.repository;

import com.myapplication.sell.dataobject.OrderDetail;
import com.myapplication.sell.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-13 17:05
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository detailRepository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456789");
        orderDetail.setOrderId("11111111");
        orderDetail.setProductId("111111222");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductName("皮蛋瘦肉粥");
        orderDetail.setProductPrice(new BigDecimal(3.8));
        orderDetail.setProductQuantity(2);
        detailRepository.save(orderDetail);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetails = detailRepository.findByOrderId("11111111");
        System.out.println("orderDetails = " + orderDetails);
    }
}