package com.feature.engine.strategy.valueparser.factory;

import com.feature.engine.strategy.valueparser.BasicValueParser;
import com.feature.engine.strategy.valueparser.CollectionValueParser;
import com.feature.engine.strategy.valueparser.ValueParserStrategy;

import java.util.HashMap;
import java.util.Map;

public class ValueParserStrategyFactory {

    private static final Map<String, ValueParserStrategy> VALUE_PARSER_STRATEGY_MAP;

    private static final String BASIC_VALUE_PARSER = "basicValueParser";
    private static final String COLLECTION_KEY_PARSER = "complexKeyParser";

    static {
        VALUE_PARSER_STRATEGY_MAP = new HashMap<>();
        VALUE_PARSER_STRATEGY_MAP.put(BASIC_VALUE_PARSER, new BasicValueParser());
        VALUE_PARSER_STRATEGY_MAP.put(COLLECTION_KEY_PARSER, new CollectionValueParser());
    }

    public static ValueParserStrategy getValueParser(String key) {
        if (key.startsWith("[")) {
            return VALUE_PARSER_STRATEGY_MAP.get(COLLECTION_KEY_PARSER);
        }
        return VALUE_PARSER_STRATEGY_MAP.get(BASIC_VALUE_PARSER);
    }
}
