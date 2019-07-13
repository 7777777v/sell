package com.myapplication.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myapplication.sell.dataobject.ProductInfo;
import lombok.Data;

import java.util.List;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-13 14:56
 * @Description:商品包含类目
 */
@Data
public class ProductVo {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;
}
