package com.dexlace.scene;

/**
 * 模拟的是spring中的类：HandlerInterceptor，实现接口功能SsoInterceptor模拟的单点登录拦截服务。
 */
public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);

}
