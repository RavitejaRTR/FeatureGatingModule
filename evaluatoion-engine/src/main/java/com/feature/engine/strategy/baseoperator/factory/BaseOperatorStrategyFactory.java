package com.feature.engine.strategy.baseoperator.factory;

import com.feature.engine.domain.OperatorType;
import com.feature.engine.strategy.baseoperator.BaseOperatorEvaluationStrategy;
import com.feature.engine.strategy.baseoperator.EqualsOperatorStrategy;

import java.util.HashMap;
import java.util.Map;

public class BaseOperatorStrategyFactory {

    private static final Map<OperatorType, BaseOperatorEvaluationStrategy> EVALUATION_STRATEGY_MAP;

    static {
        EVALUATION_STRATEGY_MAP = new HashMap<>();
        EVALUATION_STRATEGY_MAP.put(OperatorType.EQUALS, new EqualsOperatorStrategy());
    }

    public static BaseOperatorEvaluationStrategy getBaseOperatorEvaluationStrategy(OperatorType operatorType) {
        // TODO :: Check if entry exists in map for given operand and throw exception if not present
        return EVALUATION_STRATEGY_MAP.get(operatorType);
    }

}
