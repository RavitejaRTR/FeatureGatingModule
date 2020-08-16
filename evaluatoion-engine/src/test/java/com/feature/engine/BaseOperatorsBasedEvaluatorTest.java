package com.feature.engine;

import com.feature.engine.evaluator.BaseOperatorsBasedEvaluator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class BaseOperatorsBasedEvaluatorTest {
    @InjectMocks
    BaseOperatorsBasedEvaluator baseOperatorsBasedEvaluator = new BaseOperatorsBasedEvaluator();

    @Test
    public void testEvaluate() {
        String actualParsedCond = baseOperatorsBasedEvaluator.evaluate("age == 25", getUserAttributes());
        Assert.assertEquals("true", actualParsedCond);
    }

    private Map<String, Object> getUserAttributes() {
        Map<String, Object> userAttributes = new HashMap<>();
        userAttributes.put("age", 25);
        return userAttributes;
    }

}
