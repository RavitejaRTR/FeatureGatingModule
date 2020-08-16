package com.feature.engine.domain;

public class Condition {

    private Object key;

    private Object value;

    private OperatorType operatorType;

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public OperatorType getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(OperatorType operatorType) {
        this.operatorType = operatorType;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "key=" + key +
                ", value=" + value +
                ", operatorType=" + operatorType +
                '}';
    }
}
