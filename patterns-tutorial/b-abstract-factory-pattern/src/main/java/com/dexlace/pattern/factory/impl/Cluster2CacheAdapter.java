package com.dexlace.pattern.factory.impl;


import com.dexlace.pattern.factory.ICacheAdapter;
import com.dexlace.scene.matter.Cluster2;

import java.util.concurrent.TimeUnit;

public class Cluster2CacheAdapter implements ICacheAdapter {

    private Cluster2 cluster2 = new Cluster2();

    public String get(String key) {
        return cluster2.get(key);
    }

    public void set(String key, String value) {
        cluster2.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        cluster2.setExpire(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        cluster2.del(key);
    }

}
