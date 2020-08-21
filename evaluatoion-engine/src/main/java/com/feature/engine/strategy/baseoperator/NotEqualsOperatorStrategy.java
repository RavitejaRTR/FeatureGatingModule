package com.feature.engine.strategy.baseoperator;

import com.feature.engine.domain.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotEqualsOperatorStrategy implements BaseOperatorEvaluationStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotEqualsOperatorStrategy.class);

    @Override
    public boolean evaluate(Condition condition) {
        LOGGER.info("Executing notEqualsEvaluationStrategy.");
        return !condition.getKey().equals(condition.getValue());
    }
}
