package com.feature.engine;

import com.feature.engine.evaluator.LogicalOperatorsBasedEvaluator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LogicalOperatorBasedEvaluatorTest {
    @InjectMocks
    private LogicalOperatorsBasedEvaluator logicalOperatorsBasedEvaluator = new LogicalOperatorsBasedEvaluator();

    @Test
    public void testEvaluate() {
        boolean actualParsedResult = logicalOperatorsBasedEvaluator.evaluate("((false AND true) OR true)");
        Assert.assertTrue(actualParsedResult);
    }
}
