package com.dexlace.pattern;

/**
 * Effective Java 作者推荐使用枚举的方式解决单例模式，此种方式可能是平时最少用到的。
 * 这种方式解决了最主要的；线程安全、自由串行化、单一实例。
 *
 * 这种写法在功能上与共有域方法相近，但是它更简洁，无偿地提供了串行化机制，绝对防止对此实例化，
 * 即使是在面对复杂的串行化或者反射攻击的时候。
 * 虽然这中方法还没有广泛采用，但是单元素的枚举类型已经成为实现Singleton的最佳方法。
 *
 * 但也要知道此种方式在存在继承场景下是不可用的
 */
public enum Singleton_07 {

    INSTANCE;
    public void test(){
        System.out.println("hi~");
    }

}
