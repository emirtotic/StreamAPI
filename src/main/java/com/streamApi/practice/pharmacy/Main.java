package com.streamApi.practice.pharmacy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Medicine> medicines = Arrays.asList(
                new Medicine("M1", "Paracetamol", "Painkiller", 3.50, Arrays.asList(
                        new MedicineTransaction("T1", TransactionType.PURCHASE, 100, "2024-01-15"),
                        new MedicineTransaction("T2", TransactionType.SALE, 20, "2024-01-20")
                )),
                new Medicine("M2", "Amoxicillin", "Antibiotic", 10.00, Arrays.asList(
                        new MedicineTransaction("T3", TransactionType.PURCHASE, 50, "2024-02-10"),
                        new MedicineTransaction("T4", TransactionType.WITHDRAWAL, 5, "2024-02-15")
                )),
                new Medicine("M3", "Vitamin C", "Vitamin", 2.00, Arrays.asList(
                        new MedicineTransaction("T5", TransactionType.PURCHASE, 200, "2024-03-05"),
                        new MedicineTransaction("T6", TransactionType.SALE, 30, "2024-03-10"),
                        new MedicineTransaction("T7", TransactionType.SALE, 10, "2024-03-15")
                )),
                new Medicine("M4", "Ibuprofen", "Painkiller", 4.50, Arrays.asList(
                        new MedicineTransaction("T8", TransactionType.PURCHASE, 150, "2024-01-10"),
                        new MedicineTransaction("T9", TransactionType.SALE, 50, "2024-02-05")
                ))
        );

        /*
        1. Pronađite ukupan broj lekova koji su prodati (TransactionType.SALE) po kategoriji (npr. "Painkiller", "Antibiotic", itd.).
        2. Kreirajte mapu (Map<String, Double>) koja sadrži ukupnu vrednost svih transakcija po kategoriji leka (prodaja, nabavka ili povlačenje).
        3. Pronađite sve transakcije prodaje lekova koje su se dogodile pre datuma "2024-02-01".
        4. Kreirajte mapu koja sadrži ID leka kao ključ i ukupnu količinu koja je dostupna na stanju (na osnovu svih transakcija).
         */


        // 1.
        Map<String, Integer> totalMedicineByCategory =
                medicines.stream().collect(Collectors.groupingBy(
                        Medicine::getCategory,
                        Collectors.summingInt(medicine -> medicine.getTransactions().stream()
                                .filter(medicineTransaction -> medicineTransaction.getTransactionType().equals(TransactionType.SALE))
                                .mapToInt(MedicineTransaction::getQuantity)
                                .sum())
                ));

        System.out.println("Total sold medicines per category: " + totalMedicineByCategory);


    }

}
