package com.feature.engine.strategy.baseoperator;

import com.feature.engine.domain.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NoneOfOperatorStrategy implements BaseOperatorEvaluationStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoneOfOperatorStrategy.class);

    @Override
    public boolean evaluate(Condition condition) {
        LOGGER.info("Executing noneOfOperatorStrategy.");
        if (!(condition.getValue() instanceof List)) {
            return false;
        }

        for (Object value : ((List)condition.getValue())) {
            if (condition.getKey().equals(value))
                return false;
        }
        return true;
    }
}
