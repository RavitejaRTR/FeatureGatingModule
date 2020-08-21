package com.feature.engine.domain;

public class LogicalCondition {
    private String left;
    private String right;
    private LogicalOperatorType logicalOperatorType;

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public LogicalOperatorType getLogicalOperatorType() {
        return logicalOperatorType;
    }

    public void setLogicalOperatorType(LogicalOperatorType logicalOperatorType) {
        this.logicalOperatorType = logicalOperatorType;
    }
}
