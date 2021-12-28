package com.dexlace.normal;

import com.alibaba.fastjson.JSON;
import com.dexlace.scene.mq.AccountMq;

/**
 * 消息消费 其实大部分时候接MQ消息都是创建一个类用于消费，通过转换他的MQ消息属性给自己的方法。
 */
public class AccountMqConsumeService {

    public void onMessage(String message) {

        AccountMq mq = JSON.parseObject(message, AccountMq.class);

        mq.getNumber();
        mq.getAccountDate();

        // ... 处理自己的业务
    }

}
