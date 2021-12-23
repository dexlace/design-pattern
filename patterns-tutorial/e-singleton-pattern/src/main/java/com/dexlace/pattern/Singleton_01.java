package com.dexlace.pattern;

/**
 * 懒汉模式 （线程不安全）
 */
public class Singleton_01 {

    private static Singleton_01 instance;

    /**
     * 单例模式不允许new  所以必须有私有的构造函数
     */
    private Singleton_01() {
    }

    // 目前此种方式的单例确实满足了懒加载，但是如果有多个访问者同时去获取对象实例你可以想象成一堆人在抢厕所，
    // 就会造成多个同样的实例并存，从而没有达到单例的要求。
    public static Singleton_01 getInstance(){
        if (null != instance) return instance;
        return new Singleton_01();
    }

}
