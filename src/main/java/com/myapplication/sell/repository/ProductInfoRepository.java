package com.myapplication.sell.repository;

import com.myapplication.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-11 22:43
 * @Description:商品dao层
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

}
