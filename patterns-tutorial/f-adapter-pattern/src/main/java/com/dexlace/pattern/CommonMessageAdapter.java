package com.dexlace.pattern;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;


/**
 * 技术点一 模拟消息适配
 */
public class CommonMessageAdapter {

    /**
     * 把不同的MQ消息中的属性映射成我们需要的属性 并设置之 反射机制牛逼
     * @param strJson 我们接收到的消息 重载的另一个方法只是把json转换为object了而已
     * @param commonReflectSelfField 统一的属性名：各个mq中对应的属性名
     * @return 统一的消息对象
     */
    public static CommonMessage filter(String strJson, Map<String, String> commonReflectSelfField) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return filter(JSON.parseObject(strJson, Map.class), commonReflectSelfField);
    }


    public static CommonMessage filter(Map obj, Map<String, String> commonReflectSelfField) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CommonMessage commonMessage = new CommonMessage();
        for (String key : commonReflectSelfField.keySet()) {
            // common field ： self field
            // 1. 先取得self field
            // 2. 然后拿到self field对应的value
            Object val = obj.get(commonReflectSelfField.get(key));
            // 3. 执行common message中的common field对应的方法，并将self field的值value传入
            CommonMessage.class.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class)
                    .invoke(commonMessage, val.toString());
        }
        return commonMessage;
    }

}
