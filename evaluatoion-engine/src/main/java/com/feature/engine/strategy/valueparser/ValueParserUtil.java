package com.feature.engine.strategy.valueparser;

public class ValueParserUtil {

    public static Object getValueParsedValue(String value) {
        if (value.startsWith("\"")) {
            return value.substring(1, value.length() - 1);
        }
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            return Boolean.valueOf(value);
        }
    }
}
