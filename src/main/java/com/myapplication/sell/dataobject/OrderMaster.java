package com.myapplication.sell.dataobject;

import com.myapplication.sell.enums.OrderStatusEnum;
import com.myapplication.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: 2985062714@qq.com
 * @Date: 2019-07-13 16:29
 * @Description:订单实体
 */
@Data
@Entity
@DynamicUpdate
public class OrderMaster {

    @Id
    /** 订单id */
    private String orderId;

    /** 买家名字 */
    private String buyerName;

    /** 买家手机号 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信的openid */
    private String buyerOpenId;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态，默认为新下单 */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态，默认为0 未支付 */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;
}
