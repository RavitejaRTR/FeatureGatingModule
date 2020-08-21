package com.feature.engine.evaluator;

import com.feature.engine.domain.Condition;
import com.feature.engine.domain.LogicalOperatorType;
import com.feature.engine.domain.OperatorType;
import com.feature.engine.strategy.baseoperator.BaseOperatorEvaluationStrategy;
import com.feature.engine.strategy.baseoperator.factory.BaseOperatorStrategyFactory;
import com.feature.engine.strategy.keyparser.KeyParserStrategy;
import com.feature.engine.strategy.keyparser.factory.KeyParserStrategyFactory;
import com.feature.engine.strategy.valueparser.ValueParserStrategy;
import com.feature.engine.strategy.valueparser.factory.ValueParserStrategyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BaseOperatorsBasedEvaluator {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseOperatorsBasedEvaluator.class);

    // TODO :: Handle exception when passed String is not a properly formed condition
    public String evaluate(String condition, Map<String, Object> userAttributes) {
        LOGGER.info("Evaluating condition based on BaseOperators....");

        StringBuilder resultBuilder = new StringBuilder();
        String[] conditionSplitBySpace = condition.split("[ ]");
        for (int i = 0; i < conditionSplitBySpace.length; i++) {
            if (LogicalOperatorType.getLogicalOperatorByName(conditionSplitBySpace[i]).equals(LogicalOperatorType.UNKNOWN)) {
                Condition cond = new Condition();
                cond.setKey(getKey(conditionSplitBySpace[i], userAttributes));
                cond.setOperatorType(OperatorType.getOperatorTypeByName(conditionSplitBySpace[i + 1]));
                cond.setValue(getValue(conditionSplitBySpace[i + 2]));

                LOGGER.info("Invoking evaluator for condition : {}", cond);
                System.out.println(cond.toString());
                boolean result = evaluate(cond);
                //Add the beginning and ending parenthesis back to resultant string
                resultBuilder.append(resultBuilder.toString().isEmpty() ? "" : " ");
                for (char c : conditionSplitBySpace[i].toCharArray()) {
                    if(c == '(')
                        resultBuilder.append("(");
                    else
                        break;
                }
                resultBuilder.append(result ? "true" : "false");
                for (int j = conditionSplitBySpace[i + 2].toCharArray().length-1; j>=0; j--) {
                    if(conditionSplitBySpace[i + 2].toCharArray()[j] == ')')
                        resultBuilder.append(")");
                    else
                        break;
                }
                i += 2;
            } else {
                resultBuilder.append(" ")
                        .append(conditionSplitBySpace[i]);
            }
        }
        return resultBuilder.toString();
    }

    public boolean evaluate(Condition condition) {
        LOGGER.info("Evaluating condition : {}", condition);
        BaseOperatorEvaluationStrategy evaluationStrategy = BaseOperatorStrategyFactory.getBaseOperatorEvaluationStrategy(condition.getOperatorType());
        return evaluationStrategy.evaluate(condition);
    }

    private Object getKey(String key, Map<String, Object> userAttributes) {
        while (key.startsWith("("))
            key = key.replace("(", "");
        KeyParserStrategy keyParser = KeyParserStrategyFactory.getKeyParser(key);
        return keyParser.parseKey(key, userAttributes);
    }

    private Object getValue(String value) {
        while (value.endsWith(")"))
            value = value.replace(")", "");
        ValueParserStrategy valueParser = ValueParserStrategyFactory.getValueParser(value);
        return valueParser.parseValue(value);
    }

}
