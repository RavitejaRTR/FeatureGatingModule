package com.feature.engine.strategy.valueparser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CollectionValueParserTest {

    @InjectMocks
    CollectionValueParser collectionValueParser = new CollectionValueParser();

    @Test
    public void testParseValue() {
        Object actualValue = collectionValueParser.parseValue("[\"abc\",\"def\",\"hij\"]");
        List<Object> expectedValue = Arrays.asList("abc", "def", "hij");

        Assert.assertEquals(expectedValue, actualValue);
    }

}
