package com.dexlace.pattern.impl;


import com.dexlace.pattern.OrderAdapterService;
import com.dexlace.scene.service.InnerOrderMqService;

/**
 * 技术点二 模拟接口适配 场景：首单优惠场景  每个都有不同的实现
 */
public class InnerOrderAdapterServiceImpl implements OrderAdapterService {

    private InnerOrderMqService orderService = new InnerOrderMqService();

    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }

}
