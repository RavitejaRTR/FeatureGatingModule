package com.feature.engine.strategy.baseoperator;

import com.feature.engine.domain.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EqualsOperatorStrategy implements BaseOperatorEvaluationStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(EqualsOperatorStrategy.class);

    @Override
    public boolean evaluate(Condition condition) {
        LOGGER.info("Executing equalsEvaluationStrategy.");
        return condition.getKey().equals(condition.getValue());
    }
}
