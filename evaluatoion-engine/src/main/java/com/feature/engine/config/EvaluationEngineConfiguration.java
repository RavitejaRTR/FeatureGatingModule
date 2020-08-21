package com.feature.engine.config;

import com.feature.engine.evaluator.BaseOperatorsBasedEvaluator;
import com.feature.engine.evaluator.ExpressionEvaluator;
import com.feature.engine.evaluator.LogicalOperatorsBasedEvaluator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EvaluationEngineConfiguration {

    @Bean
    public ExpressionEvaluator expressionEvaluator() {
        return new ExpressionEvaluator();
    }

    @Bean
    public BaseOperatorsBasedEvaluator baseOperatorsBasedEvaluator() {
        return new BaseOperatorsBasedEvaluator();
    }

    @Bean
    public LogicalOperatorsBasedEvaluator logicalOperatorsBasedEvaluator() {
        return new LogicalOperatorsBasedEvaluator();
    }
}
