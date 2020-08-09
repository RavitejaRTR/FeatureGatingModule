package com.feature.engine.strategy.baseoperator;

import com.feature.engine.domain.Condition;

public interface BaseOperatorEvaluationStrategy {

    boolean evaluate(Condition condition);

}
