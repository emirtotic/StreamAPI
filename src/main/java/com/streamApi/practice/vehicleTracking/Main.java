package com.streamApi.practice.vehicleTracking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Vehicle> vehicles = Arrays.asList(
                new Vehicle("V1", "Truck", Arrays.asList(
                        new VehicleTransaction("T1", TransactionType.DELIVERY, 300.00, "2024-01-10"),
                        new VehicleTransaction("T2", TransactionType.MAINTENANCE, 150.00, "2024-02-05")
                )),
                new Vehicle("V2", "Van", Arrays.asList(
                        new VehicleTransaction("T3", TransactionType.DELIVERY, 200.00, "2024-03-15"),
                        new VehicleTransaction("T4", TransactionType.INSPECTION, 50.00, "2024-04-10")
                )),
                new Vehicle("V3", "Car", Arrays.asList(
                        new VehicleTransaction("T5", TransactionType.MAINTENANCE, 120.00, "2024-01-25"),
                        new VehicleTransaction("T6", TransactionType.INSPECTION, 70.00, "2024-02-20")
                )),
                new Vehicle("V4", "Truck", Arrays.asList(
                        new VehicleTransaction("T7", TransactionType.DELIVERY, 400.00, "2024-05-10"),
                        new VehicleTransaction("T8", TransactionType.MAINTENANCE, 300.00, "2024-06-15")
                ))
        );

        /*
        1. Pronađite ukupnu cenu svih transakcija za vozila tipa "Truck".
        2. Kreirajte mapu (Map<String, Double>) koja sadrži ukupnu cenu transakcija po tipu vozila (npr. "Truck", "Van", "Car").
        3. Pronađite sve transakcije koje su tipa "MAINTENANCE".
        4. Kreirajte mapu koja sadrži ID vozila kao ključ i listu ID-ova transakcija koje su starije od datuma "2024-02-01".
         */


        // 1.
        double totalOfAllTruckTransaction = vehicles.stream()
                .filter(vehicle -> vehicle.getType().equalsIgnoreCase("Truck"))
                .flatMap(t -> t.getTransactions().stream())
                .mapToDouble(VehicleTransaction::getCost)
                .sum();

        System.out.println("Total of all truck transactions: " + totalOfAllTruckTransaction);

        // 2.
        Map<String, Double> totalValueByVehicleType = vehicles.stream()
                .collect(Collectors.groupingBy(
                        Vehicle::getType, Collectors.summingDouble(vehicle -> vehicle.getTransactions().stream()
                                .mapToDouble(VehicleTransaction::getCost)
                                .sum())));

        System.out.println("Total of all transaction by vehicle type: " + totalValueByVehicleType);

        // 3.
        List<VehicleTransaction> maintenanceTransactions = vehicles.stream()
                .flatMap(vehicle -> vehicle.getTransactions().stream()
                        .filter(transaction -> transaction.getTransactionType().equals(TransactionType.MAINTENANCE)))
                .collect(Collectors.toList());

        System.out.println("Maintenance transactions: " + maintenanceTransactions);

        // 4.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate targetDate = LocalDate.parse("2024-02-01", formatter);

        Map<String, List<String>> transactionsBeforeDateByVehicle = vehicles.stream()
                .collect(Collectors.toMap(
                        Vehicle::getVehicleId, // Ključ je ID vozila
                        vehicle -> vehicle.getTransactions().stream()
                                .filter(transaction -> LocalDate.parse(transaction.getDate(), formatter).isBefore(targetDate))
                                .map(VehicleTransaction::getTransactionId) // ID-ovi transakcija stariji od datuma
                                .collect(Collectors.toList()) // Prikupljanje ID-ova transakcija u listu
                ));

        System.out.println("Transactions before '2024-02-01' by vehicles: " + transactionsBeforeDateByVehicle);

    }

}
