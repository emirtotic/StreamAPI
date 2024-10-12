package com.streamApi.practice.pcEquipment;

import java.util.List;

public class Transaction {
    private String transactionId;
    private String customerId;
    private List<Product> products;
    private TransactionStatus status; // "COMPLETED", "PENDING", "CANCELLED"
    private String transactionDate; // Format: "yyyy-MM-dd"


    public Transaction(String transactionId, String customerId, List<Product> products, TransactionStatus status, String transactionDate) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.products = products;
        this.status = status;
        this.transactionDate = transactionDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", products=" + products +
                ", status='" + status + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                '}';
    }
}