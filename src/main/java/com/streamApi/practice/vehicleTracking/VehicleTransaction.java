package com.streamApi.practice.vehicleTracking;

public
class VehicleTransaction {

    private String transactionId;
    private TransactionType transactionType;
    private double cost;
    private String date; // Format: "yyyy-MM-dd"

    // Konstruktor, getteri i setteri

    public VehicleTransaction(String transactionId, TransactionType transactionType, double cost, String date) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.cost = cost;
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public double getCost() {
        return cost;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "VehicleTransaction{" +
                "transactionId='" + transactionId + '\'' +
                ", transactionType=" + transactionType +
                ", cost=" + cost +
                ", date='" + date + '\'' +
                '}';
    }
}

