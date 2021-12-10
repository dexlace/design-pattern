package com.dexlace.scene.service;

import com.dexlace.scene.vo.CouponVO;

/**
 * 模拟优惠券服务
 */
public class CouponService {

    public CouponVO sendCoupon(String uId, String couponNumber, String uuid) {
        System.out.println("模拟发放优惠券一张：" + uId + "," + couponNumber + "," + uuid);
        return new CouponVO("0000", "发放成功");
    }

}
