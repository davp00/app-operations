package com.example.appoperations;

public class OperationItem {
    private String value;
    private String name;

    public OperationItem(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
