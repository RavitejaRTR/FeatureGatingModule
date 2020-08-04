package com.feature.engine.evaluator;

import com.feature.engine.domain.LogicalCondition;

import java.util.Map;

public class LogicalOperatorsBasedEvaluator {

    public boolean evaluate(String condition, Map<String, Object> userAttributes) {
        return false;
    }

    public boolean evaluate(LogicalCondition condition) {
        return true;
    }
}
