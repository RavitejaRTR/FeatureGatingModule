package com.feature.engine.strategy.logicaloperator.factory;

import com.feature.engine.domain.LogicalOperatorType;
import com.feature.engine.strategy.logicaloperator.AndOperatorStrategy;
import com.feature.engine.strategy.logicaloperator.LogicalOperatorEvaluationStrategy;

import java.util.HashMap;
import java.util.Map;

public class LogicalOperatorStrategyFactory {

    private static final Map<LogicalOperatorType, LogicalOperatorEvaluationStrategy> EVALUATION_STRATEGY_MAP;

    static {
        EVALUATION_STRATEGY_MAP = new HashMap<>();
        EVALUATION_STRATEGY_MAP.put(LogicalOperatorType.AND, new AndOperatorStrategy());
    }

    public static LogicalOperatorEvaluationStrategy getBaseOperatorEvaluationStrategy(LogicalOperatorType logicalOperatorType) {
        // TODO :: Check if entry exists in map for given operand and throw exception if not present
        return EVALUATION_STRATEGY_MAP.get(logicalOperatorType);
    }
}
