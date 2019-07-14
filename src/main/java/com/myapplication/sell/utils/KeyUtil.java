package com.myapplication.sell.utils;

import java.util.Random;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-14 11:01
 * @Description:生成订单号
 */
public class KeyUtil {

    /**
     *
     * 功能描述: 生成唯一的主键
     * 格式:时间+随机数
     * @param:
     * @return:
     * @auther: 2985062714@qq.com
     * @date: 2019-07-14 上午 11:02
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
