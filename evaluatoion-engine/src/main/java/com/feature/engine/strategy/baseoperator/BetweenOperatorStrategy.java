package com.feature.engine.strategy.baseoperator;

import com.feature.engine.domain.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BetweenOperatorStrategy implements BaseOperatorEvaluationStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(BetweenOperatorStrategy.class);

    @Override
    public boolean evaluate(Condition condition) {
        LOGGER.info("Executing betweenOperatorStrategy.");
        if (!(condition.getValue() instanceof List) || ((List)condition.getValue()).size()!=2) {
            return false;
        }

        return (Integer.parseInt(condition.getKey().toString()) >= Integer.parseInt(((List)condition.getValue()).get(0).toString()))
                && (Integer.parseInt(condition.getKey().toString()) <= Integer.parseInt(((List)condition.getValue()).get(1).toString()));
    }
}
