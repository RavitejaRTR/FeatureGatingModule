package com.feature.engine.strategy.keyparser;

public class KeyParserUtil {

    public static Object getKeyParsedValue(Object keyValueFromMap) {
        try {
            return Integer.valueOf(keyValueFromMap.toString());
        } catch (NumberFormatException e) {
            return Boolean.valueOf(keyValueFromMap.toString());
        } catch (Exception e) {
            return keyValueFromMap.toString();
        }
    }

}
