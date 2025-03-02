package com.example.demo.enumeration;

public enum Operator {
    EQUAL("="),
    LESS_THAN("<"),
    GREATER_THAN(">"),
    LESS_THAN_EQUAL("<="),
    IN("IN"),
    LIKE("LIKE");

    private String value;

    Operator(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
