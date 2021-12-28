package com.dexlace.scene.mq;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.Date;

/**
 * 开户  注册开户的MQ消息
 */
@Data
public class AccountMq {

    private String number;      // 开户编号
    private String address;     // 开户地
    private Date accountDate;   // 开户时间
    private String desc;        // 开户描述



    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
