package com.dexlace.pattern;


/**
 *  技术点二 模拟接口适配 场景：首单优惠场景  每个都有不同的实现
 */
public interface OrderAdapterService {

    boolean isFirst(String uId);

}
