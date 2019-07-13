package com.myapplication.sell.service.impl;

import com.myapplication.sell.dataobject.ProductInfo;
import com.myapplication.sell.enums.ProductStatusEnum;
import com.myapplication.sell.repository.ProductInfoRepository;
import com.myapplication.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-13 13:29
 * @Description:商品service实现
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public Optional<ProductInfo> findOne(String productId) {
        return repository.findById(productId);
    }

    /**
     *
     * 功能描述: 查找所有上架的商品
     *
     * @param:
     * @return:
     * @auther: 2985062714@qq.com
     * @date: 2019-07-13 下午 1:40
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}
