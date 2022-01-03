package com.dexlace.pattern.model.entity;


import lombok.Data;

import java.util.Map;

/**
 * 决策树
 */
@Data
public class DecisionTree {

    private DecisionTreeRoot decisionTreeRoot;                          //树根信息
    /**
     * 存储父节点的id 和子节点的DecisionTreeNode
     */
    private Map<Long, DecisionTreeNode> treeNodeMap;        //树节点ID -> 子节点

    public DecisionTree(DecisionTreeRoot decisionTreeRoot, Map<Long, DecisionTreeNode> treeNodeMap) {
        this.decisionTreeRoot = decisionTreeRoot;
        this.treeNodeMap = treeNodeMap;
    }


}
