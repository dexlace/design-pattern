package com.dexlace.pattern;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Singleton_00 {

    // 这不算严格意义上的静态类 只是他只有一个静态变量而已  所以看作广义上的静态类  这里不会延迟加载
    public static Map<String,String> cache = new ConcurrentHashMap<String, String>();

}
