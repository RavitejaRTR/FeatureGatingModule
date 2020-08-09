package com.feature.engine.strategy.logicaloperator;

import com.feature.engine.domain.LogicalCondition;

public interface LogicalOperatorEvaluationStrategy {

    boolean evaluate(LogicalCondition logicalCondition);

}
