package com.feature.engine.strategy.baseoperator.factory;

import com.feature.engine.domain.OperatorType;
import com.feature.engine.strategy.baseoperator.*;

import java.util.HashMap;
import java.util.Map;

public class BaseOperatorStrategyFactory {

    private static final Map<OperatorType, BaseOperatorEvaluationStrategy> EVALUATION_STRATEGY_MAP;

    static {
        EVALUATION_STRATEGY_MAP = new HashMap<>();
        EVALUATION_STRATEGY_MAP.put(OperatorType.EQUALS, new EqualsOperatorStrategy());
        EVALUATION_STRATEGY_MAP.put(OperatorType.ALLOF, new AllOfOperatorStrategy());
        EVALUATION_STRATEGY_MAP.put(OperatorType.BETWEEN, new BetweenOperatorStrategy());
        EVALUATION_STRATEGY_MAP.put(OperatorType.GREATER_THAN, new GreaterThanOperatorStrategy());
        EVALUATION_STRATEGY_MAP.put(OperatorType.GREATER_THAN_OR_EQUALS, new GreaterThanOrEqualsOperatorStrategy());
        EVALUATION_STRATEGY_MAP.put(OperatorType.LESS_THAN, new LessThanOperatorStrategy());
        EVALUATION_STRATEGY_MAP.put(OperatorType.LESS_THAN_OR_EQUALS, new LessThanOrEqualsOperatorStrategy());
        EVALUATION_STRATEGY_MAP.put(OperatorType.NONEOF, new NoneOfOperatorStrategy());
        EVALUATION_STRATEGY_MAP.put(OperatorType.NOT_EQUALS, new NotEqualsOperatorStrategy());
    }

    public static BaseOperatorEvaluationStrategy getBaseOperatorEvaluationStrategy(OperatorType operatorType) {
        // TODO :: Check if entry exists in map for given operand and throw exception if not present
        return EVALUATION_STRATEGY_MAP.get(operatorType);
    }

}
