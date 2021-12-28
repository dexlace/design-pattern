package com.dexlace.scene.mq;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 第三方订单 MQ
 */
@Data
public class OuterOrderMq {

    private String uId;     // 用户ID
    private String orderId; // 订单号
    private Date orderTime; // 下单时间
    private Date sku;       // 商品
    private Date skuName;   // 商品名称
    private BigDecimal decimal; // 金额



    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
