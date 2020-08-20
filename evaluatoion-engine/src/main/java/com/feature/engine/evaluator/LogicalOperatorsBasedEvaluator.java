package com.feature.engine.evaluator;

import com.feature.engine.domain.LogicalCondition;
import com.feature.engine.domain.LogicalOperatorType;
import com.feature.engine.strategy.logicaloperator.LogicalOperatorEvaluationStrategy;
import com.feature.engine.strategy.logicaloperator.factory.LogicalOperatorStrategyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class LogicalOperatorsBasedEvaluator {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogicalOperatorsBasedEvaluator.class);

    public boolean evaluate(String condition) {
        Stack<String> evaluationStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int currentIndex = 0;
        while (currentIndex < condition.length()) {
            if (condition.charAt(currentIndex) == '(') {
                evaluationStack.push("(");
                sb.setLength(0);
            } else if (condition.charAt(currentIndex) == ')') {
                if (!evaluationStack.isEmpty() &&
                        LogicalOperatorType.getLogicalOperatorByName(evaluationStack.peek()) != LogicalOperatorType.UNKNOWN) {
                    LogicalCondition logicalCondition = new LogicalCondition();
                    logicalCondition.setRight(sb.toString());
                    logicalCondition.setLogicalOperatorType(LogicalOperatorType.getLogicalOperatorByName(evaluationStack.peek()));
                    evaluationStack.pop();
                    logicalCondition.setLeft(evaluationStack.pop());
                    boolean result = evaluate(logicalCondition);
                    sb.setLength(0);
                    if (evaluationStack.peek().equals("(")) {
                        evaluationStack.pop();
                        evaluationStack.push(String.valueOf(result));
                    } else {
                        sb.append(result);
                        currentIndex--;
                    }
                }
            } else if (condition.charAt(currentIndex) == ' ') {
                if (!evaluationStack.isEmpty() &&
                        LogicalOperatorType.getLogicalOperatorByName(evaluationStack.peek()) != LogicalOperatorType.UNKNOWN) {
                    LogicalCondition logicalCondition = new LogicalCondition();
                    logicalCondition.setRight(sb.toString());
                    logicalCondition.setLogicalOperatorType(LogicalOperatorType.getLogicalOperatorByName(evaluationStack.peek()));
                    evaluationStack.pop();
                    logicalCondition.setLeft(evaluationStack.pop());
                    boolean result = evaluate(logicalCondition);
                    sb = new StringBuilder(String.valueOf(result));
                }
                if(!sb.toString().isEmpty())
                    evaluationStack.push(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(condition.charAt(currentIndex));
            }
            // If end of condition is reached
            if (currentIndex == condition.length() - 1) {
                if (!evaluationStack.isEmpty() &&
                        LogicalOperatorType.getLogicalOperatorByName(evaluationStack.peek()) != LogicalOperatorType.UNKNOWN) {
                    LogicalCondition logicalCondition = new LogicalCondition();
                    logicalCondition.setRight(sb.toString());
                    logicalCondition.setLogicalOperatorType(LogicalOperatorType.getLogicalOperatorByName(evaluationStack.peek()));
                    evaluationStack.pop();
                    logicalCondition.setLeft(evaluationStack.pop());
                    boolean result = evaluate(logicalCondition);
                    evaluationStack.push(String.valueOf(result));
                }
                break;
            }
            currentIndex++;
        }
        return Boolean.valueOf(evaluationStack.peek());
    }

    public boolean evaluate(LogicalCondition condition) {
        LOGGER.info("Evaluating logical condition : {}", condition);
        System.out.println(condition);
        LogicalOperatorEvaluationStrategy logicalOperatorEvaluationStrategy = LogicalOperatorStrategyFactory.getLogicalOperatorEvaluationStrategy(condition.getLogicalOperatorType());
        return logicalOperatorEvaluationStrategy.evaluate(condition);
    }
}
