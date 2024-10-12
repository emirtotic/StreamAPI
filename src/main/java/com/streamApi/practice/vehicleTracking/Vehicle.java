package com.streamApi.practice.vehicleTracking;

import java.util.List;

public class Vehicle {

    private String vehicleId;
    private String type; // "Truck", "Van", "Car", itd.
    private List<VehicleTransaction> transactions;


    public Vehicle(String vehicleId, String type, List<VehicleTransaction> transactions) {
        this.vehicleId = vehicleId;
        this.type = type;
        this.transactions = transactions;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getType() {
        return type;
    }

    public List<VehicleTransaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", type='" + type + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
