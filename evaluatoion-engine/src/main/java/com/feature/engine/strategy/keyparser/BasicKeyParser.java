package com.feature.engine.strategy.keyparser;

import java.util.Map;

public class BasicKeyParser implements KeyParserStrategy {

    @Override
    public Object parseKey(String key, Map<String, Object> userAttributes) {
        Object keyMapValue = userAttributes.get(key);
        return KeyParserUtil.getKeyParsedValue(keyMapValue);
    }
}
