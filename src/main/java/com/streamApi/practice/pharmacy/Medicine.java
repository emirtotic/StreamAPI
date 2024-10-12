package com.streamApi.practice.pharmacy;

import java.util.List;

public class Medicine {

    private String medicineId;
    private String name;
    private String category; // "Antibiotic", "Painkiller", "Vitamin", itd.
    private double price;
    private List<MedicineTransaction> transactions;

    // Konstruktor, getteri i setteri

    public Medicine(String medicineId, String name, String category, double price, List<MedicineTransaction> transactions) {
        this.medicineId = medicineId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.transactions = transactions;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public List<MedicineTransaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineId='" + medicineId + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", transactions=" + transactions +
                '}';
    }

}
