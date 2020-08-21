package com.feature.engine.strategy.keyparser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ComplexKeyParser implements KeyParserStrategy {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComplexKeyParser.class);

    @Override
    public Object parseKey(String key, Map<String, Object> userAttributes) {
        try {
            String[] keys = key.split("[.]");
            Object complexObject = userAttributes.get(keys[0]);
            for (int i = 1; i < keys.length; i++) {
                if (i == keys.length - 1)
                    return KeyParserUtil.getKeyParsedValue(complexObject.getClass().getField(keys[i]).get(complexObject));
                complexObject = complexObject.getClass().getField(keys[i]).get(complexObject);
            }
        } catch (Exception e) {
            LOGGER.info("Exception while parsing for key : {}", key);
        }
        throw new RuntimeException("No corresponding entry found in Map for key : " + key);
    }
}
