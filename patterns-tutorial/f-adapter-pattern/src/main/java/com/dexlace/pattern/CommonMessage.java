package com.dexlace.pattern;

import lombok.Data;

/**
 *  技术点一 统一的MQ消息体  后续把所有接入进来的消息进行统一的处理
 */
@Data
public class CommonMessage {

    private String userId;  // 用户ID
    private String bizId;   // 业务ID
    private String bizTime;   // 业务时间
    private String desc;    // 业务描述


}
