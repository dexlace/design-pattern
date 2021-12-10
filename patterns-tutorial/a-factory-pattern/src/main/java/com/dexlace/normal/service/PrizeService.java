package com.dexlace.normal.service;


import com.alibaba.fastjson.JSON;
import com.dexlace.normal.dto.AwardReqDTO;
import com.dexlace.normal.vo.AwardResVO;
import com.dexlace.scene.dto.DeliverDTO;
import com.dexlace.scene.service.CouponService;
import com.dexlace.scene.service.GoodsService;
import com.dexlace.scene.service.IQiYiCardService;
import com.dexlace.scene.vo.CouponVO;
import lombok.extern.slf4j.Slf4j;


/**
 * 模拟发奖服务
 */
@Slf4j
public class PrizeService {



    public AwardResVO awardToUser(AwardReqDTO req) {
        String reqJson = JSON.toJSONString(req);
        AwardResVO awardResVO = null;
        try {
            log.info("奖品发放开始{}。req:{}", req.getUId(), reqJson);
            // 按照不同类型方法商品[1优惠券、2实物商品、3第三方兑换卡(爱奇艺)]
            if (req.getAwardType() == 1) {
                CouponService couponService = new CouponService();
                CouponVO couponResult = couponService.sendCoupon(req.getUId(), req.getAwardNumber(), req.getBizId());
                if ("0000".equals(couponResult.getCode())) {
                    awardResVO = new AwardResVO("0000", "发放成功");
                } else {
                    awardResVO = new AwardResVO("0001", couponResult.getInfo());
                }
            } else if (req.getAwardType() == 2) {
                GoodsService goodsService = new GoodsService();
                DeliverDTO deliverReq = new DeliverDTO();
                deliverReq.setUserName(queryUserName(req.getUId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(req.getUId()));
                deliverReq.setSku(req.getAwardNumber());
                deliverReq.setOrderId(req.getBizId());
                deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
                deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
                Boolean isSuccess = goodsService.deliverGoods(deliverReq);
                if (isSuccess) {
                    awardResVO = new AwardResVO("0000", "发放成功");
                } else {
                    awardResVO = new AwardResVO("0001", "发放失败");
                }
            } else if (req.getAwardType() == 3) {
                String bindMobileNumber = queryUserPhoneNumber(req.getUId());
                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                iQiYiCardService.grantToken(bindMobileNumber, req.getAwardNumber());
                awardResVO = new AwardResVO("0000", "发放成功");
            }
            log.info("奖品发放完成{}。", req.getUId());
        } catch (Exception e) {
            log.error("奖品发放失败{}。req:{}", req.getUId(), reqJson, e);
            awardResVO = new AwardResVO("0001", e.getMessage());
        }

        return awardResVO;
    }

    private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }

}
