package com.streamApi.practice.pharmacy;

public class MedicineTransaction {

    private String transactionId;
    private TransactionType transactionType;
    private int quantity;
    private String transactionDate; // Format: "yyyy-MM-dd"

    // Konstruktor, getteri i setteri

    public MedicineTransaction(String transactionId, TransactionType transactionType, int quantity, String transactionDate) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.transactionDate = transactionDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {
        return "MedicineTransaction{" +
                "transactionId='" + transactionId + '\'' +
                ", transactionType=" + transactionType +
                ", quantity=" + quantity +
                ", transactionDate='" + transactionDate + '\'' +
                '}';
    }
}
