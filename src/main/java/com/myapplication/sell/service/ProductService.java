package com.myapplication.sell.service;

import com.myapplication.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-13 13:24
 * @Description:商品service
 */
public interface ProductService {

    Optional<ProductInfo> findOne(String productId);

    /**
     *
     * 功能描述: 查询所有在架商品列表
     *
     * @param:
     * @return:
     * @auther: 2985062714@qq.com
     * @date: 2019-07-13 下午 1:25
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存


    //减库存
}
