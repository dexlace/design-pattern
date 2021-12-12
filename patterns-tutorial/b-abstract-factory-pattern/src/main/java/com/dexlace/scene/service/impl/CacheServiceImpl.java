package com.dexlace.scene.service.impl;


import com.dexlace.scene.CacheService;
import com.dexlace.scene.RedisUtils;

import java.util.concurrent.TimeUnit;

public class CacheServiceImpl implements CacheService {

    private final RedisUtils redisUtils = new RedisUtils();

    public String get(String key) {
        return redisUtils.get(key);
    }

    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisUtils.set(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        redisUtils.del(key);
    }

}
