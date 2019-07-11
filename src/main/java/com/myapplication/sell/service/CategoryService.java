package com.myapplication.sell.service;

import com.myapplication.sell.dataobject.ProductCategory;

import java.util.List;
import java.util.Optional;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-10 22:26
 * @Description:
 */

public interface CategoryService {
    /** 查询一条数据*/
    Optional<ProductCategory> findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory category);

}
