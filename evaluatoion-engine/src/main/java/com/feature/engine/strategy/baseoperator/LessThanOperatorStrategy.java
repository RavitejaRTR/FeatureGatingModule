package com.feature.engine.strategy.baseoperator;

import com.feature.engine.domain.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LessThanOperatorStrategy implements BaseOperatorEvaluationStrategy {
    private static final Logger LOGGER = LoggerFactory.getLogger(LessThanOperatorStrategy.class);

    @Override
    public boolean evaluate(Condition condition) {
        LOGGER.info("Executing lessThanOperatorStrategy.");
        return Integer.parseInt(condition.getKey().toString()) < Integer.parseInt(condition.getValue().toString());
    }
}
