package com.dexlace.pattern.service.logic.impl;


import com.dexlace.pattern.service.logic.BaseLogic;

import java.util.Map;

/**
 * 性别节点  实际的业务开发可以从数据库、RPC接口、缓存运算等各种方式获取
 */
public class UserGenderFilter extends BaseLogic {

    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("gender");
    }

}
