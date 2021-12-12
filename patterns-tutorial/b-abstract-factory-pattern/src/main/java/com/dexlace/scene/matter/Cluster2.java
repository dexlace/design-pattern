package com.dexlace.scene.matter;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;


@Slf4j
public class Cluster2 {

    private final Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String get(String key) {
        log.info("Cluster2获取数据 key：{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        log.info("Cluster2写入数据 key：{} val：{}", key, value);
        dataMap.put(key, value);
    }

    public void setExpire(String key, String value, long timeout, TimeUnit timeUnit) {
        log.info("Cluster2写入数据 key：{} val：{} timeout：{} timeUnit：{}", key, value, timeout, timeUnit.toString());
        dataMap.put(key, value);
    }

    public void del(String key) {
        log.info("Cluster2删除数据 key：{}", key);
        dataMap.remove(key);
    }

}
