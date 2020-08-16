package com.feature.engine.strategy.keyparser.factory;

import com.feature.engine.strategy.keyparser.BasicKeyParser;
import com.feature.engine.strategy.keyparser.ComplexKeyParser;
import com.feature.engine.strategy.keyparser.KeyParserStrategy;

import java.util.HashMap;
import java.util.Map;

public class KeyParserStrategyFactory {

    private static final Map<String, KeyParserStrategy> KEY_PARSER_STRATEGY_MAP;

    private static final String BASIC_KEY_PARSER = "basicKeyParser";
    private static final String COMPLEX_KEY_PARSER = "complexKeyParser";

    static {
        KEY_PARSER_STRATEGY_MAP = new HashMap<>();
        KEY_PARSER_STRATEGY_MAP.put(BASIC_KEY_PARSER, new BasicKeyParser());
        KEY_PARSER_STRATEGY_MAP.put(COMPLEX_KEY_PARSER, new ComplexKeyParser());
    }

    public static KeyParserStrategy getKeyParser(String key) {
        if (key.contains(".")) {
            return KEY_PARSER_STRATEGY_MAP.get(COMPLEX_KEY_PARSER);
        }
        return KEY_PARSER_STRATEGY_MAP.get(BASIC_KEY_PARSER);
    }
}
