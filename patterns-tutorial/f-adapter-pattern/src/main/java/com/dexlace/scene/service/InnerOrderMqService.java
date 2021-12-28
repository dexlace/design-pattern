package com.dexlace.scene.service;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class InnerOrderMqService {

    public long queryUserOrderCount(String userId){
        log.info("自营商家，查询用户的订单是否为首单：{}", userId);
        return 10L;
    }

}
