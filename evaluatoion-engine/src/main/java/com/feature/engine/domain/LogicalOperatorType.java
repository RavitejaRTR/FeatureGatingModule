package com.feature.engine.domain;

public enum LogicalOperatorType {

    AND("AND"),
    OR("OR"),
    UNKNOWN("unknown");

    private String name;

    private  LogicalOperatorType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LogicalOperatorType getLogicalOperatorByName(String name) {
        for (LogicalOperatorType logicalOperatorType:LogicalOperatorType.values()) {
            if (logicalOperatorType.getName().equals(name))
                return logicalOperatorType;
        }
        return LogicalOperatorType.UNKNOWN;
    }

}
