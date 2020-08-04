package com.feature.engine.domain;

public enum OperatorType {
    /* Supported OperatorTypes
    >, >=, <=, <, ==, !=, BETWEEN, ALLOF, NONEOF
    */
    GREATER_THAN(">"),
    GREATER_THAN_OR_EQUALS(">="),
    LESS_THAN("<"),
    LESS_THAN_OR_EQUALS("<="),
    EQUALS("=="),
    NOT_EQUALS("!="),
    BETWEEN("BETWEEN"),
    ALLOF("ALLOF"),
    NONEOF("NONEOF"),
    UNKNOWN("unknown");

    private String name;

    OperatorType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public OperatorType getOperatorTypeByName(String name) {
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.getName().equals(name))
                return operatorType;
        }
        return OperatorType.UNKNOWN;
    }
}
