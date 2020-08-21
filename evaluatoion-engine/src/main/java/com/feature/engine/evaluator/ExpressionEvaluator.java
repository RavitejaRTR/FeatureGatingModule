package com.feature.engine.evaluator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Map;

@Component
public class ExpressionEvaluator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpressionEvaluator.class);

    @Inject
    private BaseOperatorsBasedEvaluator baseOperatorsBasedEvaluator;

    @Inject
    private LogicalOperatorsBasedEvaluator logicalOperatorsBasedEvaluator;

    public boolean isAllowed(String condition, String featureName, Map<String, Object> userAttributes) {
        LOGGER.info("Evaluating condition : {}", condition);
        String baseOperatorSolvedCondition = baseOperatorsBasedEvaluator.evaluate(condition, userAttributes);
        System.out.println(baseOperatorSolvedCondition);
        return false;
    }

}
