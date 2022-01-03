package com.dexlace.pattern.service.decision;


import com.dexlace.pattern.model.entity.DecisionTree;
import com.dexlace.pattern.model.vo.DecisionResult;
import com.dexlace.pattern.model.entity.DecisionTreeNode;
import com.dexlace.pattern.model.entity.DecisionTreeRoot;
import com.dexlace.pattern.service.logic.LogicFilter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;


@Slf4j
public abstract class DecisionEngineBase extends DecisionConfig implements IDecisionEngine {


    @Override
    public abstract DecisionResult process(Long treeId, String userId, DecisionTree decisionTree, Map<String, String> decisionMatter);


    protected DecisionTreeNode engineDecisionMaker(DecisionTree decisionTree,
                                                   Long treeId, String userId,
                                                   Map<String, String> decisionMatter) {
        DecisionTreeRoot decisionTreeRoot = decisionTree.getDecisionTreeRoot();
        Map<Long, DecisionTreeNode> treeNodeMap = decisionTree.getTreeNodeMap();
        // 决策树根ID
        Long rootNodeId = decisionTreeRoot.getTreeRootNodeId();
        /**
         * 从根开始迭代
         */
        DecisionTreeNode decisionTreeNodeInfo = treeNodeMap.get(rootNodeId);
        //节点类型[NodeType]；1子叶、2果实
        while (decisionTreeNodeInfo != null && decisionTreeNodeInfo.getNodeType().equals(1)) {
            /**
             * 拿到匹配规则的key userAge 或者 userGender
             */
            String ruleKey = decisionTreeNodeInfo.getRuleKey();
            /**
             * 拿到对应的规则处理器 UserAgeFilter 或者 UserGenderFilter
             */
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            /**
             * 拿到决策值
             */
            String matterValue = logicFilter.matterValue(treeId, userId, decisionMatter);
            /**
             * 决策并路由到下一个节点
             */
            Long nextNode = logicFilter.filter(matterValue, decisionTreeNodeInfo.getDecisionProcessDTOList());
            /**
             * 打印下一个节点的信息
             */
            decisionTreeNodeInfo = treeNodeMap.get(nextNode);

            if (decisionTreeNodeInfo != null)
                log.info("决策树引擎=>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}",
                        decisionTreeRoot.getTreeName(), userId, treeId, decisionTreeNodeInfo.getTreeNodeId(), ruleKey, matterValue);

        }
        /**
         * 这是最终路由的决策结果
         */
        return decisionTreeNodeInfo;
    }

}
