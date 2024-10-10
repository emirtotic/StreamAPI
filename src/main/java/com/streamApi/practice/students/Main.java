package com.streamApi.practice.students;

import com.streamApi.practice.orders.Order;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Alice", 19, 3.5, "Computer Science", 1),
                new Student("Bob", 21, 3.2, "Mathematics", 3),
                new Student("Charlie", 20, 3.8, "Physics", 2),
                new Student("Diana", 22, 3.9, "Computer Science", 4),
                new Student("Eve", 20, 2.8, "Mathematics", 2),
                new Student("Frank", 19, 3.0, "Physics", 1),
                new Student("Grace", 21, 3.6, "Computer Science", 3),
                new Student("Hank", 22, 2.9, "Mathematics", 4)
        );

        /*
        1. Pronađite prosečan GPA svih studenata sa smerom "Computer Science".
        2. Grupisanje studenata po godini studija i izračunavanje prosečnog GPA za svaku godinu.
        3. Kreirajte listu studenata sa GPA većim od 3.0, sortiranu po GPA u opadajućem redosledu.
        4. Pronađite sve smerove koji imaju bar jednog studenta na prvoj godini studija.
         */

        // 1.
        double averageGpaOnCS =
                students.stream().filter(s ->
                                s.getMajor().equalsIgnoreCase("Computer science"))
                        .mapToDouble(Student::getGpa)
                        .average().orElse(0.0);

        //2.
        Map<Integer, List<Student>> studentsByYear =
                students.stream().collect(Collectors.groupingBy(Student::getYear)
                );

        Map<Integer, Double> averageGpaByYear =
                studentsByYear.entrySet().stream()
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        entry -> entry.getValue().stream().mapToDouble(Student::getGpa).average().orElse(0.0)
                                ));

        //3.
        List<Student> studentsAbove3Gpa = students.stream()
                .filter(student -> student.getGpa() > 3.0)
                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                .collect(Collectors.toList());


        //4.
        List<String> allCategoriesWithAtLeastOneStudent = students.stream()
                .filter(s -> s.getYear() == 1)
                .map(Student::getMajor)
                .distinct()
                .toList();

    }

}
