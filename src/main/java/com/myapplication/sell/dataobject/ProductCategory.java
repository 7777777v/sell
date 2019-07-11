package com.myapplication.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-10 20:41
 * @Description:
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {
    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    /** 类目id */

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer categoryId;

    /** 类目名字 */
    private String categoryName;

    /**类目编号 */
    private Integer categoryType;

/*    private Date createTime;

    private Date updateTime;*/
}