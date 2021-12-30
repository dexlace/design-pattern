package com.dexlace.pattern.pay.channel;


import com.dexlace.pattern.pay.mode.IPayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;


public abstract class Pay {

    protected Logger logger = LoggerFactory.getLogger(Pay.class);

    /**
     * 组合了另一个类  并在另一个类的构造函数中传入该类
     */
    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    /**
     * 交易接口
     * @param uId
     * @param tradeId
     * @param amount
     * @return
     */
    public abstract String transfer(String uId, String tradeId, BigDecimal amount);

}
