package com.dexlace.pattern.service.logic.impl;


import com.dexlace.pattern.service.logic.BaseLogic;

import java.util.Map;

/**
 * 年龄节点
 */
public class UserAgeFilter extends BaseLogic {

    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("age");
    }

}
