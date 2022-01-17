package com.dexlace.scene;

public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);

}
