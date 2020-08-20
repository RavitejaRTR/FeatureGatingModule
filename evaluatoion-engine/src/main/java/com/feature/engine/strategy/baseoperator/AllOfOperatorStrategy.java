package com.feature.engine.strategy.baseoperator;

import com.feature.engine.domain.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AllOfOperatorStrategy implements BaseOperatorEvaluationStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllOfOperatorStrategy.class);

    @Override
    public boolean evaluate(Condition condition) {
        LOGGER.info("Executing allOfOperatorStrategy.");
        if (!(condition.getKey() instanceof List && condition.getValue() instanceof List)) {
            return false;
        }

        Set<Object> keySet = (Set<Object>) ((List)condition.getKey()).stream().collect(Collectors.toSet());
        Set<Object> valueSet = (Set<Object>) ((List)condition.getValue()).stream().collect(Collectors.toSet());

        if (keySet.size() != valueSet.size()) {
            return false;
        }

        for (Object keySetValue : keySet) {
            if (valueSet.contains(keySetValue)) {
                return false;
            }
        }
        return true;
    }
}
