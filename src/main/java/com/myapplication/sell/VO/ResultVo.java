package com.myapplication.sell.VO;

import lombok.Data;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-13 14:50
 * @Description:http请求返回的最外层对象
 */
@Data
public class ResultVo<T> {

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 返回数据 */
    private T data;
}
