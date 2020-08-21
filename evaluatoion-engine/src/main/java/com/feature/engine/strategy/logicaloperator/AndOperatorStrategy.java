package com.feature.engine.strategy.logicaloperator;

import com.feature.engine.domain.LogicalCondition;

public class AndOperatorStrategy implements LogicalOperatorEvaluationStrategy {

    @Override
    public boolean evaluate(LogicalCondition logicalCondition) {
        return Boolean.valueOf(logicalCondition.getLeft()) & Boolean.valueOf(logicalCondition.getRight());
    }
}
