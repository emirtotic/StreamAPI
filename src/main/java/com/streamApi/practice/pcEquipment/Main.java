package com.streamApi.practice.pcEquipment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", "C1", Arrays.asList(new Product("Laptop", 1200.00, "Electronics"), new Product("Mouse", 20.00, "Electronics")), TransactionStatus.COMPLETED, "2024-01-15"),
                new Transaction("T2", "C2", Arrays.asList(new Product("Book", 15.00, "Books")), TransactionStatus.PENDING, "2024-02-10"),
                new Transaction("T3", "C3", Arrays.asList(new Product("Desk", 150.00, "Furniture"), new Product("Chair", 80.00, "Furniture")), TransactionStatus.COMPLETED, "2024-03-05"),
                new Transaction("T4", "C1", Arrays.asList(new Product("Smartphone", 800.00, "Electronics")), TransactionStatus.CANCELLED, "2024-04-22"),
                new Transaction("T5", "C2", Arrays.asList(new Product("Monitor", 300.00, "Electronics")), TransactionStatus.COMPLETED, "2024-05-18"),
                new Transaction("T6", "C3", Arrays.asList(new Product("Headphones", 50.00, "Electronics"), new Product("Keyboard", 25.00, "Electronics")), TransactionStatus.COMPLETED, "2024-06-01")
        );

        /*
        1. Pronađite ukupnu vrednost svih završenih ("COMPLETED") transakcija.
        2. Kreirajte mapu (Map<String, Double>) koja sadrži ukupnu vrednost transakcija po
           kategoriji proizvoda (npr. "Electronics", "Books", itd.).
        3. Pronađite sve transakcije koje sadrže proizvod iz kategorije "Electronics".
        4. Pronađite ukupnu vrednost svih proizvoda za svakog kupca (customerId).
        */

        // 1.
        double totalValueOfCompletedTransactions = transactions.stream()
                .filter(transaction -> transaction.getStatus() == TransactionStatus.COMPLETED) // Filtriramo samo završene transakcije
                .flatMap(transaction -> transaction.getProducts().stream()) // Svaku transakciju razdvajamo na proizvode
                .mapToDouble(Product::getPrice) // Uzimamo cenu svakog proizvoda
                .sum(); // Sabiramo sve cene

        System.out.println("Total value of completed transactions: " + totalValueOfCompletedTransactions);

        // 2.
        Map<String, Double> totalValueByCategory = transactions.stream()
                .filter(transaction -> transaction.getStatus() == TransactionStatus.COMPLETED) // Filtriramo samo završene transakcije
                .flatMap(transaction -> transaction.getProducts().stream()) // Razdvajamo transakcije na proizvode
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice))); // Grupisanje po kategoriji i sumiranje cena

        System.out.println("Total value of transaction by category: " + totalValueByCategory);

        // 3.
        List<Transaction> transactionsWithElectronics = transactions.stream()
                .filter(transaction -> transaction.getProducts().stream()
                        .anyMatch(product -> product.getCategory().equalsIgnoreCase("Electronics"))) // Proveravamo da li transakcija sadrži proizvod iz kategorije Electronics
                .collect(Collectors.toList());

        System.out.println("Transactions which contains products from category 'Electronics': " + transactionsWithElectronics);

        // 4.
        Map<String, Double> totalValuePerCustomer = transactions.stream()
                .filter(transaction -> transaction.getStatus() == TransactionStatus.COMPLETED) // Filtriramo samo završene transakcije
                .collect(Collectors.groupingBy(Transaction::getCustomerId,
                        Collectors.summingDouble(transaction -> transaction.getProducts().stream()
                                .mapToDouble(Product::getPrice)
                                .sum())));

        System.out.println("Total transactions value per Customer: " + totalValuePerCustomer);


    }

}
