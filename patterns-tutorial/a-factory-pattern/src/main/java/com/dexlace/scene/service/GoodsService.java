package com.dexlace.scene.service;


import com.alibaba.fastjson.JSON;
import com.dexlace.scene.dto.DeliverDTO;

/**
 * 模拟实物商品服务
 */
public class GoodsService {

    public Boolean deliverGoods(DeliverDTO req) {
        System.out.println("模拟发货实物商品一个：" + JSON.toJSONString(req));
        return true;
    }

}
