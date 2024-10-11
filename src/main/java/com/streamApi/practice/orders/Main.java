package com.streamApi.practice.orders;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
                new Order("O1", "Alice", 120.00, "COMPLETED", "Electronics"),
                new Order("O2", "Bob", 50.00, "PENDING", "Books"),
                new Order("O3", "Charlie", 200.00, "COMPLETED", "Clothing"),
                new Order("O4", "Diana", 80.00, "CANCELLED", "Books"),
                new Order("O5", "Eve", 300.00, "COMPLETED", "Electronics"),
                new Order("O6", "Frank", 150.00, "PENDING", "Clothing"),
                new Order("O7", "Grace", 90.00, "COMPLETED", "Books"),
                new Order("O8", "Hank", 250.00, "CANCELLED", "Electronics")
        );

        /*
        1. Pronađite ukupan iznos svih završenih ("COMPLETED") narudžbina.
        2. Grupisanje narudžbina po kategoriji i izračunavanje ukupnog iznosa narudžbina za svaku kategoriju.
        3. Kreirajte listu narudžbina čija je vrednost iznad proseka svih završenih narudžbina.
        4. Pronađite sve kategorije koje imaju barem jednu narudžbinu sa statusom "PENDING".
         */


        // 1.
        double totalSumOfCompletedOrders =
                orders.stream().filter(o -> o.getStatus().equalsIgnoreCase("Completed"))
                        .mapToDouble(Order::getTotalAmount)
                        .sum();

        System.out.println("Total sum of completed orders: " + totalSumOfCompletedOrders);

        // 2.
        Map<String, List<Order>> groupByCategory =
                orders.stream().collect(Collectors.groupingBy(Order::getCategory));

        Map<String, Double> sumByCategory =
                groupByCategory.entrySet().stream()
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        entry -> entry.getValue().stream()
                                                .mapToDouble(Order::getTotalAmount).sum()
                                ));

        // 3.
        double averageAmount = orders.stream()
                .filter(order -> order.getStatus().equalsIgnoreCase("COMPLETED"))
                .mapToDouble(Order::getTotalAmount)
                .average()
                .orElse(0.0);

        List<Order> ordersAboveAverage =
                orders.stream()
                        .filter(order -> order.getStatus().equalsIgnoreCase("COMPLETED"))
                        .filter(order -> order.getTotalAmount() > averageAmount)
                        .toList();



        //4.
        List<String> categoriesWithPending = orders.stream()
                .filter(o -> o.getStatus().equalsIgnoreCase("PENDING"))
                .map(Order::getCategory)
                .distinct()
                .toList();

    }

}
