package com.dexlace.scene;

/**
 * 简单功能
 * 这里的模拟实现非常简单只是截取字符串，
 * 实际使用需要从HttpServletRequest request对象中获取cookie信息，解析ticket值做校验。
 * 在返回的里面也非常简单，只要获取到了success就认为是允许登录。
 */
public class SsoInterceptor implements HandlerInterceptor{

    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取cookie
        String ticket = request.substring(1, 8);
        // 模拟校验
        return ticket.equals("success");
    }

}
