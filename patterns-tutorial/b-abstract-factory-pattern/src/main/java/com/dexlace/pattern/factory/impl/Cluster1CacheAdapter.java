package com.dexlace.pattern.factory.impl;


import com.dexlace.pattern.factory.ICacheAdapter;
import com.dexlace.scene.matter.Cluster1;

import java.util.concurrent.TimeUnit;

public class Cluster1CacheAdapter implements ICacheAdapter {

    private Cluster1 cluster1 = new Cluster1();

    public String get(String key) {
        return cluster1.gain(key);
    }

    public void set(String key, String value) {
        cluster1.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        cluster1.setEx(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        cluster1.delete(key);
    }
}
