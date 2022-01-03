package com.dexlace.pattern.model.dto;

import lombok.Data;

/**
 * 决策树过程信息 即一个决策的执行逻辑
 * 从nodeIdFrom经过规则ruleLimitType限制了值ruleLimitValue
 * 得到决策的下一个节点nodeIdTo
 */
@Data
public class DecisionProcessDTO {

    private Long nodeIdFrom;        //节点From
    private Long nodeIdTo;          //节点To
    private Integer ruleLimitType;  //限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围]
    private String ruleLimitValue;  //限定值

}
