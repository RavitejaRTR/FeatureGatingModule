package com.feature.engine.strategy.keyparser;

import java.util.Map;

public class BasicKeyParser implements KeyParserStrategy {

    @Override
    public String parseKey(String key, Map<String, Object> userAttributes) {
        // Even if it is a collection type, it is read as the class's toString implementation
        return userAttributes.get(key).toString();
    }
}
