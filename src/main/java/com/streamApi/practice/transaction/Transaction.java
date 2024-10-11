package com.streamApi.practice.transaction;

public class Transaction {

    private String id;
    private String type; // "DEPOSIT" ili "WITHDRAWAL"
    private double amount;
    private String accountNumber;

    public Transaction(String id, String type, double amount, String accountNumber) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }

}
