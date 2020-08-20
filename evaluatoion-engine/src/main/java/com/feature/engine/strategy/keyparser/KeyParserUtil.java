package com.feature.engine.strategy.keyparser;

public class KeyParserUtil {

    public static Object getKeyParsedValue(Object keyValueFromMap) {
        try {
            return Integer.valueOf(keyValueFromMap.toString());
        } catch (NumberFormatException e) {
            if(keyValueFromMap.equals("true") || keyValueFromMap.equals("false"))
                return Boolean.valueOf(keyValueFromMap.toString());
            return keyValueFromMap.toString();
        }
    }

}
