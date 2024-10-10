package com.streamApi.practice.employees;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, 5000, "IT"),
                new Employee("Bob", 45, 6000, "Finance"),
                new Employee("Charlie", 28, 4000, "IT"),
                new Employee("Diana", 50, 7000, "Finance"),
                new Employee("Eve", 35, 6500, "HR"),
                new Employee("Frank", 40, 5500, "IT"),
                new Employee("Grace", 31, 4500, "HR"),
                new Employee("Hank", 29, 4800, "Finance")
        );

        /*
        1. Pronađite najplaćenijeg zaposlenog u svakom odeljenju.
        2. Izračunajte ukupan broj zaposlenih mlađih od 35 godina.
        3. Kreirajte mapu koja sadrži prosečnu platu po odeljenju.
        4. Napravite listu svih zaposlenih čija plata prelazi prosečnu platu njihovog odeljenja.
         */

        Map<String, List<Employee>> filterByDepartment =
                employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        int under35 = (int) employees.stream().filter(e -> e.getAge() < 35).count();

        Map<String, Double> averageSalaryByDepartment = filterByDepartment.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        employee -> employee.getValue().stream()
                                .mapToDouble(Employee::getSalary).average().orElse(0.0)
                ));

        Map<String, Employee> mostPayedByDepartment = filterByDepartment.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .max(Comparator.comparingDouble(Employee::getSalary))
                                .orElse(null) // Ako nema zaposlenih u odeljenju
                ));

        List<Employee> payedAboveAverage = employees.stream()
                .filter(e -> e.getSalary() > averageSalaryByDepartment.get(e.getDepartment()))
                .collect(Collectors.toList());

        payedAboveAverage.forEach(System.out::println);

    }

}
