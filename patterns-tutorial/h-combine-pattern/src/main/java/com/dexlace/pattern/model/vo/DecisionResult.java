package com.dexlace.pattern.model.vo;

import lombok.Data;

/**
 * 决策结果
 */
@Data
public class DecisionResult {

    private boolean isSuccess; //执行结果
    private String userId;   //用户ID
    private Long treeId;     //规则树ID
    private Long nodeId;   //果实节点ID
    private String nodeValue;//果实节点值

    public DecisionResult() {
    }

    public DecisionResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public DecisionResult(String userId, Long treeId, Long nodeId, String nodeValue) {
        this.isSuccess = true;
        this.userId = userId;
        this.treeId = treeId;
        this.nodeId = nodeId;
        this.nodeValue = nodeValue;
    }


}
