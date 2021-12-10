package com.dexlace.pattern;


import com.dexlace.pattern.service.ICommodity;
import com.dexlace.pattern.service.impl.CardCommodityService;
import com.dexlace.pattern.service.impl.CouponCommodityService;
import com.dexlace.pattern.service.impl.GoodsCommodityService;

public class StoreFactory {

    // 定义了一个商店的工厂类，在里面按照类型实现各种商品的服务。可以非常干净整洁的处理你的代码，后续新增的商品在这里扩展即可
    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        if (3 == commodityType) return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }

}
