package com.feature.engine.strategy.valueparser;

public class BasicValueParser implements ValueParserStrategy {
    @Override
    public Object parseValue(String value) {
        return ValueParserUtil.getValueParsedValue(value);
    }
}
