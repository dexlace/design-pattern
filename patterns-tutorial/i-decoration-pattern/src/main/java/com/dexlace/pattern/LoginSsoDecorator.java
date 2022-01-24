package com.dexlace.pattern;

import com.dexlace.scene.HandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginSsoDecorator extends SsoDecorator {

    private Logger logger = LoggerFactory.getLogger(LoginSsoDecorator.class);

    private static Map<String, String> authMap = new ConcurrentHashMap<String, String>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        boolean success = super.preHandle(request, response, handler);
        if (!success) return false;
        String userId = request.substring(8);
        String method = authMap.get(userId);
        logger.info("模拟单点登录方法访问拦截校验：{} {}", userId, method);
        // 模拟方法校验
        return "queryUserInfo".equals(method);
    }


    /**
     * 使用方法在这里
     */
//    @Test
//    public void test_LoginSsoDecorator() {
//        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterceptor());
//        String request = "1successhuahua";
//        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
//        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));
//    }

}
