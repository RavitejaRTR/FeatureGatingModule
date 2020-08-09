package com.feature.engine.evaluator;

import com.feature.engine.domain.Condition;
import com.feature.engine.domain.LogicalOperatorType;
import com.feature.engine.domain.OperatorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BaseOperatorsBasedEvaluator {

    private static final Logger logger = LoggerFactory.getLogger(BaseOperatorsBasedEvaluator.class);

    // TODO :: Handle exception when passed String is not a properly formed condition
    public String evaluate(String condition, Map<String, Object> userAttributes) {
        logger.info("Evaluating condition based on BaseOperators....");

        StringBuilder resultBuilder = new StringBuilder();
        String[] conditionSplitBySpace = condition.split(" ");
        for (int i = 0; i < conditionSplitBySpace.length; i++) {
            if (LogicalOperatorType.getLogicalOperatorByName(conditionSplitBySpace[i]).equals(LogicalOperatorType.UNKNOWN)) {
                Condition cond = new Condition();
                cond.setKey(conditionSplitBySpace[i]);
                cond.setOperatorType(OperatorType.getOperatorTypeByName(conditionSplitBySpace[i + 1]));
                cond.setValue(conditionSplitBySpace[i + 2]);

                boolean result = evaluate(cond);
                resultBuilder.append(cond.getKey().startsWith("(") ? " (" : " ")
                        .append(result ? "true" : "false")
                        .append(cond.getValue().endsWith(")") ? ")" : "");
                i += 2;
            } else {
                resultBuilder.append(" ")
                        .append(conditionSplitBySpace[i]);
            }
        }
        return resultBuilder.toString();
    }

    public boolean evaluate(Condition condition) {
        logger.info("Evaluating condition : {}", condition);


        return true;
    }

}
