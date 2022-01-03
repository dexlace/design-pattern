package com.dexlace.pattern.service.decision.impl;

import com.dexlace.pattern.model.entity.DecisionTree;
import com.dexlace.pattern.model.vo.DecisionResult;
import com.dexlace.pattern.model.entity.DecisionTreeNode;
import com.dexlace.pattern.service.decision.DecisionEngineBase;

import java.util.Map;

public class DecisionEngineHandle extends DecisionEngineBase {

    @Override
    public DecisionResult process(Long treeId, String userId, DecisionTree decisionTree, Map<String, String> decisionMatter) {
        // 决策流程
        DecisionTreeNode decisionTreeNode = engineDecisionMaker(decisionTree, treeId, userId, decisionMatter);
        // 决策结果
        return new DecisionResult(userId, treeId, decisionTreeNode.getTreeNodeId(), decisionTreeNode.getNodeValue());
    }

}
