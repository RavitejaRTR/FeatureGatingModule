package com.feature.engine;

import com.feature.engine.config.EvaluationEngineConfiguration;
import com.feature.engine.evaluator.ExpressionEvaluator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;

@ComponentScan
public class Client {

    public static void main(String[] args) {
        System.out.println("Welcome to my application");

        ApplicationContext context = new AnnotationConfigApplicationContext(EvaluationEngineConfiguration.class);

        ExpressionEvaluator expressionEvaluator = (ExpressionEvaluator) context.getBean("expressionEvaluator");

        expressionEvaluator.isAllowed("(age > 25 AND gender == \"Male\") OR (past_order_amount > 10000)", "abc", new HashMap<>());

    }
}
