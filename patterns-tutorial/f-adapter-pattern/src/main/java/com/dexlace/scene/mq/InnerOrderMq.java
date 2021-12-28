package com.dexlace.scene.mq;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.Date;

/**
 * 用户内部订单MQ
 */
@Data
public class InnerOrderMq {

    private String uid;           // 用户ID
    private String sku;           // 商品
    private String orderId;       // 订单ID
    private Date createOrderTime; // 下单时间



    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
