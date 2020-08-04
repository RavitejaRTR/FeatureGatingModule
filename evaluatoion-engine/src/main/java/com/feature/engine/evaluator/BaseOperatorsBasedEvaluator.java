package com.feature.engine.evaluator;

import com.feature.engine.domain.Condition;

import java.util.Map;

public class BaseOperatorsBasedEvaluator {

    public boolean evaluate(String condition, Map<String, Object> userAttributes) {
        return false;
    }

    public boolean evaluate(Condition condition) {
        return true;
    }

}
