package com.myapplication.sell.service.impl;

import com.myapplication.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-10 22:31
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {

        Optional<ProductCategory> category = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),category.get().getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> categories = categoryService.findAll();
        for(ProductCategory category : categories){
            System.out.println("category = " + category);
        }
    }

    @Test
    public void findByCategoryTypeIn() {
    }

    @Test
    public void save() {
        ProductCategory category = new ProductCategory("男士专享",10);
        ProductCategory result = categoryService.save(category);
        Assert.assertNotEquals(result,null);
    }
}