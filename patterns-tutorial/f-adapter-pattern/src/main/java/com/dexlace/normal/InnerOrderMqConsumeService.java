package com.dexlace.normal;


import com.alibaba.fastjson.JSON;
import com.dexlace.scene.mq.InnerOrderMq;

/**
 * 消息消费 其实大部分时候接MQ消息都是创建一个类用于消费，通过转换他的MQ消息属性给自己的方法。
 */
public class InnerOrderMqConsumeService {

    public void onMessage(String message) {

        InnerOrderMq mq = JSON.parseObject(message, InnerOrderMq.class);

        mq.getUid();
        mq.getOrderId();
        mq.getCreateOrderTime();

        // ... 处理自己的业务
    }

}
