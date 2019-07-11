package com.myapplication.sell.repository;

import com.myapplication.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-10 20:47
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        Optional<ProductCategory> category = repository.findById(1);
        System.out.println("category = " + category);
    }
    @Test
    public void saveTest(){
        ProductCategory category = new ProductCategory("女生最爱",1);
        ProductCategory result = repository.save(category);
        Assert.assertNotNull(result);
        /*Assert.assertNotEquals(null,result);*/
        System.out.println("save");
    }
    /*@Test
    public void updateTest(){
        ProductCategory category = new ProductCategory();
        category.setCategoryId(1);
        category.setCategoryName("男生最爱");
        category.setCategoryType(3);
        repository.save(category);
        System.out.println("update");
    }*/
    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> integerList = Arrays.asList(1,3);
        List<ProductCategory> categories = repository.findByCategoryTypeIn(integerList);
        for (ProductCategory category : categories){
            System.out.println("category = " + category);
        }
    }
}