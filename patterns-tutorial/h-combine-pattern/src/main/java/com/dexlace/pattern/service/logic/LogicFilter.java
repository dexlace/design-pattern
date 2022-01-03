package com.dexlace.pattern.service.logic;


import com.dexlace.pattern.model.dto.DecisionProcessDTO;

import java.util.List;
import java.util.Map;


public interface LogicFilter {

    /**
     * 逻辑决策器
     * 对一系列的树节点进行逻辑过滤
     * 即将一系列节点根据不同的逻辑进行路由到下一个节点
     * @param matterValue          决策值
     * @param treeNodeLineInfoList 决策节点  是一个集合 因为我们是将
     *                             matterValue与一个个TreeNodeLink上的ruleLimitValue
     *                             来比较并路由的
     * @return 下一个节点Id
     */
    Long filter(String matterValue, List<DecisionProcessDTO> treeNodeLineInfoList);

    /**
     * 获取决策值
     * 仅仅是从map中获取决策值而已  没别的了
     * @param decisionMatter 决策物料
     * @return 决策值
     */
    String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);

}
