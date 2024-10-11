package com.streamApi.practice.transaction;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", "DEPOSIT", 200.00, "ACC1"),
                new Transaction("T2", "WITHDRAWAL", 150.00, "ACC2"),
                new Transaction("T3", "DEPOSIT", 300.00, "ACC1"),
                new Transaction("T4", "WITHDRAWAL", 50.00, "ACC3"),
                new Transaction("T5", "DEPOSIT", 400.00, "ACC2"),
                new Transaction("T6", "DEPOSIT", 250.00, "ACC3"),
                new Transaction("T7", "WITHDRAWAL", 100.00, "ACC1"),
                new Transaction("T8", "WITHDRAWAL", 200.00, "ACC2")
        );

        /*
        1. Pronađite ukupan iznos samo depozita za sve transakcije.
        2. Kreirajte mapu (Map<String, Double>) koja sadrži ukupan iznos transakcija po tipu (DEPOSIT ili WITHDRAWAL).
        3. Grupisanje transakcija po broju računa i izračunavanje ukupnog iznosa transakcija za svaki račun.
        4. Filtrirajte i kreirajte listu svih transakcija gde je iznos transakcije veći od prosečnog iznosa svih transakcija u listi.
         */

        // 1.
        double totalSumOfDeposits =
                transactions.stream().filter(t ->
                                t.getType().equalsIgnoreCase("DEPOSIT"))
                        .mapToDouble(Transaction::getAmount)
                        .sum();

        // 2.
        Map<String, List<Transaction>> groupByType =
                transactions.stream().collect(Collectors.groupingBy(Transaction::getType));

        Map<String, Double> sumByType =
                groupByType.entrySet().stream().collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream().mapToDouble(Transaction::getAmount).sum()
                ));

        // 3.
        Map<String, List<Transaction>> groupByAccount =
                transactions.stream().collect(Collectors.groupingBy(Transaction::getAccountNumber));

        Map<String, Double> sumByAccount =
                groupByAccount.entrySet().stream()
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        entry -> entry.getValue().stream().mapToDouble(Transaction::getAmount).sum()
                                ));

        // 4.
        double averageOfAll = transactions.stream().mapToDouble(Transaction::getAmount).average().orElse(0.0);

        List<Transaction> largerThanAverage =
                transactions.stream().filter(t -> t.getAmount() > averageOfAll)
                        .toList();

    }

}
