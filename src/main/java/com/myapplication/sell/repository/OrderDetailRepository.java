package com.myapplication.sell.repository;

import com.myapplication.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-13 16:59
 * @Description:
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    
    List<OrderDetail> findByOrOrderId(String orderId);
}
