package com.feature.engine.strategy.keyparser;

import com.feature.engine.domain.OperatorType;

import java.util.Map;

public interface KeyParserStrategy {

    String parseKey(String key, Map<String, Object> userAttributes);

}
