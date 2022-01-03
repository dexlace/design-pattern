package com.dexlace.pattern.service.decision;


import com.dexlace.pattern.model.entity.DecisionTree;
import com.dexlace.pattern.model.vo.DecisionResult;

import java.util.Map;

public interface IDecisionEngine {

    DecisionResult process(final Long treeId, final String userId, DecisionTree decisionTree, final Map<String, String> decisionMatter);

}
