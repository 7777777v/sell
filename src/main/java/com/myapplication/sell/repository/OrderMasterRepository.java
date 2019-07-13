package com.myapplication.sell.repository;

import com.myapplication.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-13 16:48
 * @Description:订单dao层
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    Page<OrderMaster> findByBuyerOpenId(String buyerOpenId, Pageable pageable);
}
