package com.myapplication.sell.repository;

import com.myapplication.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-10 20:45
 * @Description:
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
