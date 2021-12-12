package com.dexlace.normal.service.impl;


import com.dexlace.normal.CacheService;
import com.dexlace.scene.RedisUtils;
import com.dexlace.scene.matter.Cluster1;
import com.dexlace.scene.matter.Cluster2;

import java.util.concurrent.TimeUnit;


/**
 * 默认使用单节点 如需使用集群，根据redisType来确定使用哪个集群
 *
 */
public class CacheServiceImpl implements CacheService {

    private RedisUtils redisUtils = new RedisUtils();

    private Cluster1 cluster1 = new Cluster1();

    private Cluster2 cluster2 = new Cluster2();

    public String get(String key, int redisType) {

        // 使用集群1
        if (1 == redisType) {
            return cluster1.gain(key);
        }

        // 使用集群2
        if (2 == redisType) {
            return cluster2.get(key);
        }

        // 否则默认使用单节点
        return redisUtils.get(key);
    }

    public void set(String key, String value, int redisType) {

        if (1 == redisType) {
            cluster1.set(key, value);
            return;
        }

        if (2 == redisType) {
            cluster2.set(key, value);
            return;
        }

        redisUtils.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType) {

        if (1 == redisType) {
            cluster1.setEx(key, value, timeout, timeUnit);
            return;
        }

        if (2 == redisType) {
            cluster2.setExpire(key, value, timeout, timeUnit);
            return;
        }

        redisUtils.set(key, value, timeout, timeUnit);
    }

    public void del(String key, int redisType) {

        if (1 == redisType) {
            cluster1.delete(key);
            return;
        }

        if (2 == redisType) {
            cluster2.del(key);
            return;
        }

        redisUtils.del(key);
    }


}
