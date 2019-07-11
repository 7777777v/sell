package com.myapplication.sell.service.impl;

import com.myapplication.sell.dataobject.ProductCategory;
import com.myapplication.sell.repository.ProductCategoryRepository;
import com.myapplication.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-10 22:29
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;
    @Override
    public Optional<ProductCategory> findOne(Integer categoryId) {

        return repository.findById(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory category) {
        return repository.save(category);
    }
}
