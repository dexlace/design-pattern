package com.dexlace.pattern.model.entity;

import lombok.Data;

/**
 * 决策树的root信息
 */
@Data
public class DecisionTreeRoot {

    private Long treeId;         //规则树ID
    private Long treeRootNodeId; //规则树根ID
    private String treeName;     //规则树名称

}
