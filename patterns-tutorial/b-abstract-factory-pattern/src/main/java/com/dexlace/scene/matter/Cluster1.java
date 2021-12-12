package com.dexlace.scene.matter;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

// redis服务器集群

@Slf4j
public class Cluster1 {

    private final Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String gain(String key) {
        log.info("Cluster1获取数据 key：{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        log.info("Cluster1写入数据 key：{} val：{}", key, value);
        dataMap.put(key, value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit) {
        log.info("Cluster1写入数据 key：{} val：{} timeout：{} timeUnit：{}", key, value, timeout, timeUnit.toString());
        dataMap.put(key, value);
    }

    public void delete(String key) {
        log.info("Cluster1删除数据 key：{}", key);
        dataMap.remove(key);
    }
}
