package com.feature.engine.strategy.baseoperator;

import com.feature.engine.domain.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreaterThanOperatorStrategy implements BaseOperatorEvaluationStrategy {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreaterThanOperatorStrategy.class);

    @Override
    public boolean evaluate(Condition condition) {
        LOGGER.info("Executing greaterThanOperatorStrategy.");
        return Integer.parseInt(condition.getKey().toString()) > Integer.parseInt(condition.getValue().toString());
    }
}
