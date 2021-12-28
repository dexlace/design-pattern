package com.dexlace;

import com.alibaba.fastjson.JSON;
import com.dexlace.pattern.CommonMessage;
import com.dexlace.pattern.CommonMessageAdapter;
import com.dexlace.scene.mq.AccountMq;
import com.dexlace.scene.mq.InnerOrderMq;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;

public class CommonMessageAdapterTest {

    @Test
    public  void  test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        AccountMq accountMq = new AccountMq();
        accountMq.setNumber("100001");
        accountMq.setAddress("宇宙");
        accountMq.setAccountDate(new Date());
        accountMq.setDesc("vip开户");

        HashMap<String, String> commonReflectSelfField = new HashMap<>();
        commonReflectSelfField.put("userId", "number");
        commonReflectSelfField.put("bizId", "number");
        commonReflectSelfField.put("bizTime", "accountDate");
        commonReflectSelfField.put("desc", "desc");
        CommonMessage commonMessage = CommonMessageAdapter.filter(accountMq.toString(), commonReflectSelfField);
        System.out.println("accountMq(适配前)" + accountMq.toString());
        System.out.println("accountMq(适配后)" + JSON.toJSONString(commonMessage));

        System.out.println("");

        InnerOrderMq orderMq = new InnerOrderMq();
        orderMq.setUid("100001");
        orderMq.setSku("10928092093111123");
        orderMq.setOrderId("100000890193847111");
        orderMq.setCreateOrderTime(new Date());

        HashMap<String, String> commonReflectSelfField2 = new HashMap<String, String>();
        commonReflectSelfField2.put("userId", "uid");
        commonReflectSelfField2.put("bizId", "orderId");
        commonReflectSelfField2.put("bizTime", "createOrderTime");
        CommonMessage commonMessage2 = CommonMessageAdapter.filter(orderMq.toString(), commonReflectSelfField2);

        System.out.println("InnerOrderMq(适配前)" + orderMq.toString());
        System.out.println("InnerOrderMq(适配后)" + JSON.toJSONString(commonMessage2));
    }
}
