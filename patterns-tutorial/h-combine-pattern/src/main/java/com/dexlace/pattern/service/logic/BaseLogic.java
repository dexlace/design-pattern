package com.dexlace.pattern.service.logic;


import com.dexlace.pattern.model.dto.DecisionProcessDTO;

import java.util.List;
import java.util.Map;

/**
 * 决策抽象类  提供基础决策服务
 */
public abstract class BaseLogic implements LogicFilter {

    /**
     * @param matterValue      决策值
     * @param decisionProcessDTOList 决策的过程link信息 list
     * @return 下一个节点
     */
    @Override
    public Long filter(String matterValue, List<DecisionProcessDTO> decisionProcessDTOList) {
        for (DecisionProcessDTO nodeLine : decisionProcessDTOList) {
            if (decisionLogic(matterValue, nodeLine)) {
                return nodeLine.getNodeIdTo();
            }
        }
        return 0L;
    }

    @Override
    public abstract String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);

    /**
     * @param matterValue 决策值
     * @param nodeLink    决策的过程link信息
     * @return true or false
     */
    private boolean decisionLogic(String matterValue, DecisionProcessDTO nodeLink) {
        // 根据限定的枚举值去做决策
        switch (nodeLink.getRuleLimitType()) {
            case 1: // 等于
                return matterValue.equals(nodeLink.getRuleLimitValue());
            case 2: // >
                return Double.parseDouble(matterValue) > Double.parseDouble(nodeLink.getRuleLimitValue());
            case 3: // < ...
                return Double.parseDouble(matterValue) < Double.parseDouble(nodeLink.getRuleLimitValue());
            case 4:
                return Double.parseDouble(matterValue) >= Double.parseDouble(nodeLink.getRuleLimitValue());
            case 5:
                return Double.parseDouble(matterValue) <= Double.parseDouble(nodeLink.getRuleLimitValue());
            default:
                return false;
        }
    }

}
