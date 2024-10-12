package com.streamApi.practice.pcEquipment;

public enum TransactionStatus {

    COMPLETED("COMPLETED"),
    PENDING("PENDING"),
    CANCELLED("CANCELLED");

    private String name;

    TransactionStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
