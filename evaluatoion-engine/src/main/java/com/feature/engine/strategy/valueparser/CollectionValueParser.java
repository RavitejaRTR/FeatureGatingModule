package com.feature.engine.strategy.valueparser;

import java.util.ArrayList;
import java.util.List;

public class CollectionValueParser implements ValueParserStrategy {

    @Override
    public Object parseValue(String value) {
        String valueTrimmed = value.substring(1, value.length() - 1);
        String[] commaSeparatedValues = valueTrimmed.split("[,]");

        List<Object> values = new ArrayList<>();
        for (String s : commaSeparatedValues) {
            values.add(ValueParserUtil.getValueParsedValue(s));
        }
        return values;
    }
}
