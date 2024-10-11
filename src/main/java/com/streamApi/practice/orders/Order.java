package com.streamApi.practice.orders;

public class Order {

    private String orderId;
    private String customerName;
    private double totalAmount;
    private String status; // "PENDING", "COMPLETED", "CANCELLED"
    private String category; // "Electronics", "Books", "Clothing", itd.


    public Order(String orderId, String customerName, double totalAmount, String status, String category) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.status = status;
        this.category = category;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

}
