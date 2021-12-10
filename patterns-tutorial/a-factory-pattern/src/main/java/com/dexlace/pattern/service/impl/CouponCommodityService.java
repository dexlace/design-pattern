package com.dexlace.pattern.service.impl;


import com.alibaba.fastjson.JSON;
import com.dexlace.pattern.service.ICommodity;
import com.dexlace.scene.service.CouponService;
import com.dexlace.scene.vo.CouponVO;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class CouponCommodityService implements ICommodity {



    // 模拟注入
    private CouponService couponService = new CouponService();

    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        CouponVO couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        log.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        log.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        if (!"0000".equals(couponResult.getCode())) throw new RuntimeException(couponResult.getInfo());
    }

}
