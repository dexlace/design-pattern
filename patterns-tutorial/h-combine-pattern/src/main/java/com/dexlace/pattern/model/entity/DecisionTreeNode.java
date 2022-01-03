package com.dexlace.pattern.model.entity;

import com.dexlace.pattern.model.dto.DecisionProcessDTO;
import lombok.Data;

import java.util.List;

/**
 * 决策树的节点信息 基本信息及描述该节点应该去匹配什么规则 ruleKey
 */
@Data
public class DecisionTreeNode {

    private Long treeId;            //规则树ID
    private Long treeNodeId;        //规则树节点ID
    private Integer nodeType;       //节点类型；1子叶、2果实
    private String nodeValue;       //节点值[nodeType=2]；果实值
    private String ruleKey;         //规则Key
    private String ruleDesc;        //规则描述
    private List<DecisionProcessDTO> decisionProcessDTOList; //节点链路

}
