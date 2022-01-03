package com.dexlace;

import com.alibaba.fastjson.JSON;
import com.dexlace.pattern.model.dto.DecisionProcessDTO;
import com.dexlace.pattern.model.entity.DecisionTree;
import com.dexlace.pattern.model.entity.DecisionTreeNode;
import com.dexlace.pattern.model.entity.DecisionTreeRoot;
import com.dexlace.pattern.model.vo.DecisionResult;
import com.dexlace.pattern.service.decision.IDecisionEngine;
import com.dexlace.pattern.service.decision.impl.DecisionEngineHandle;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    private DecisionTree decisionTree;

    @Before
    public void init() {

        // 节点：1
        DecisionTreeNode node_01 = new DecisionTreeNode();
        node_01.setTreeId(10001L);
        node_01.setTreeNodeId(1L);
        node_01.setNodeType(1);
        node_01.setNodeValue(null);
        node_01.setRuleKey("userGender");
        node_01.setRuleDesc("用户性别[男/女]");



        // 链接：1->11
        DecisionProcessDTO nodeLink_11 = new DecisionProcessDTO();
        nodeLink_11.setNodeIdFrom(1L);
        nodeLink_11.setNodeIdTo(11L);
        nodeLink_11.setRuleLimitType(1);
        nodeLink_11.setRuleLimitValue("man");

        // 链接：1->12
        DecisionProcessDTO nodeLink_12 = new DecisionProcessDTO();
        nodeLink_12.setNodeIdFrom(1L);
        nodeLink_12.setNodeIdTo(12L);
        nodeLink_12.setRuleLimitType(1);
        nodeLink_12.setRuleLimitValue("woman");

        List<DecisionProcessDTO> treeNodeLinkList_1 = new ArrayList<>();
        treeNodeLinkList_1.add(nodeLink_11);
        treeNodeLinkList_1.add(nodeLink_11);

        /**
         * node_01的决策路径
         */
        node_01.setDecisionProcessDTOList(treeNodeLinkList_1);

        // 节点：11
        DecisionTreeNode node_11 = new DecisionTreeNode();
        node_11.setTreeId(10001L);
        node_11.setTreeNodeId(11L);
        node_11.setNodeType(1);
        node_11.setNodeValue(null);
        node_11.setRuleKey("userAge");
        node_11.setRuleDesc("用户年龄");

        // 链接：11->111
        DecisionProcessDTO treeNodeLink_111 = new DecisionProcessDTO();
        treeNodeLink_111.setNodeIdFrom(11L);
        treeNodeLink_111.setNodeIdTo(111L);
        treeNodeLink_111.setRuleLimitType(3);
        treeNodeLink_111.setRuleLimitValue("25");

        // 链接：11->112
        DecisionProcessDTO nodeLink_112 = new DecisionProcessDTO();
        nodeLink_112.setNodeIdFrom(11L);
        nodeLink_112.setNodeIdTo(112L);
        nodeLink_112.setRuleLimitType(4);
        nodeLink_112.setRuleLimitValue("25");

        List<DecisionProcessDTO> treeNodeLinkList_11 = new ArrayList<>();
        treeNodeLinkList_11.add(treeNodeLink_111);
        treeNodeLinkList_11.add(treeNodeLink_111);

        node_11.setDecisionProcessDTOList(treeNodeLinkList_11);

        // 节点：12
        DecisionTreeNode node_12 = new DecisionTreeNode();
        node_12.setTreeId(10001L);
        node_12.setTreeNodeId(12L);
        node_12.setNodeType(1);
        node_12.setNodeValue(null);
        node_12.setRuleKey("userAge");
        node_12.setRuleDesc("用户年龄");

        // 链接：12->121
        DecisionProcessDTO treeNodeLink_121 = new DecisionProcessDTO();
        treeNodeLink_121.setNodeIdFrom(12L);
        treeNodeLink_121.setNodeIdTo(121L);
        treeNodeLink_121.setRuleLimitType(3);
        treeNodeLink_121.setRuleLimitValue("25");

        // 链接：12->122
        DecisionProcessDTO treeNodeLink_122 = new DecisionProcessDTO();
        treeNodeLink_122.setNodeIdFrom(12L);
        treeNodeLink_122.setNodeIdTo(122L);
        treeNodeLink_122.setRuleLimitType(4);
        treeNodeLink_122.setRuleLimitValue("25");

        List<DecisionProcessDTO> treeNodeLinkList_12 = new ArrayList<>();
        treeNodeLinkList_12.add(treeNodeLink_121);
        treeNodeLinkList_12.add(treeNodeLink_122);

        node_12.setDecisionProcessDTOList(treeNodeLinkList_12);


        /**
         * 果实节点的定义  即决策的结果
         */
        // 节点：111
        DecisionTreeNode treeNode_111 = new DecisionTreeNode();
        treeNode_111.setTreeId(10001L);
        treeNode_111.setTreeNodeId(111L);
        treeNode_111.setNodeType(2);
        treeNode_111.setNodeValue("果实A");

        // 节点：112
        DecisionTreeNode treeNode_112 = new DecisionTreeNode();
        treeNode_112.setTreeId(10001L);
        treeNode_112.setTreeNodeId(112L);
        treeNode_112.setNodeType(2);
        treeNode_112.setNodeValue("果实B");

        // 节点：121
        DecisionTreeNode treeNode_121 = new DecisionTreeNode();
        treeNode_121.setTreeId(10001L);
        treeNode_121.setTreeNodeId(121L);
        treeNode_121.setNodeType(2);
        treeNode_121.setNodeValue("果实C");

        // 节点：122
        DecisionTreeNode treeNode_122 = new DecisionTreeNode();
        treeNode_122.setTreeId(10001L);
        treeNode_122.setTreeNodeId(122L);
        treeNode_122.setNodeType(2);
        treeNode_122.setNodeValue("果实D");

        // 树根
        DecisionTreeRoot treeRoot = new DecisionTreeRoot();
        treeRoot.setTreeId(10001L);
        treeRoot.setTreeRootNodeId(1L);
        treeRoot.setTreeName("规则决策树");

        Map<Long, DecisionTreeNode> treeNodeMap = new HashMap<>();
        treeNodeMap.put(1L, node_01);
        treeNodeMap.put(11L, node_11);
        treeNodeMap.put(12L, node_12);
        treeNodeMap.put(111L, treeNode_111);
        treeNodeMap.put(112L, treeNode_112);
        treeNodeMap.put(121L, treeNode_121);
        treeNodeMap.put(122L, treeNode_122);

        decisionTree = new DecisionTree(treeRoot, treeNodeMap);

    }

    @Test
    public void test_tree() {
        logger.info("决策树组合结构信息：\r\n" + JSON.toJSONString(decisionTree));

        IDecisionEngine treeEngineHandle = new DecisionEngineHandle();

        Map<String, String> decisionMatter = new HashMap<>();
        decisionMatter.put("gender", "man");
        decisionMatter.put("age", "29");

        DecisionResult result = treeEngineHandle.process(10001L, "Oli09pLkdjh", decisionTree, decisionMatter);
        logger.info("测试结果：{}", JSON.toJSONString(result));

    }
}
