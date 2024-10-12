package com.streamApi.practice.vehicleTracking;

public enum TransactionType {

    DELIVERY("DELIVERY"),
    MAINTENANCE("MAINTENANCE"),
    INSPECTION("INSPECTION");

    private String name;

    TransactionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
