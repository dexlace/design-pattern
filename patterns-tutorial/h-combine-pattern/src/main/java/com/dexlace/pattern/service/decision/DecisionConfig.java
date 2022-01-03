package com.dexlace.pattern.service.decision;


import com.dexlace.pattern.service.logic.LogicFilter;
import com.dexlace.pattern.service.logic.impl.UserAgeFilter;
import com.dexlace.pattern.service.logic.impl.UserGenderFilter;
import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 将可提供服务的决策节点配置到map结构中
 */
@Data
public class DecisionConfig {

    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }



}
