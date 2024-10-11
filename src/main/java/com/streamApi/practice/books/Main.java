package com.streamApi.practice.books;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
                new Book("1984", "George Orwell", 9.99, "Fiction", 1949),
                new Book("To Kill a Mockingbird", "Harper Lee", 7.99, "Fiction", 1960),
                new Book("A Brief History of Time", "Stephen Hawking", 15.99, "Science", 1988),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99, "Fiction", 1925),
                new Book("The Art of War", "Sun Tzu", 5.99, "Non-Fiction", -500),
                new Book("The Catcher in the Rye", "J.D. Salinger", 8.99, "Fiction", 1951),
                new Book("Sapiens", "Yuval Noah Harari", 12.99, "Non-Fiction", 2011),
                new Book("Dune", "Frank Herbert", 14.99, "Science Fiction", 1965)
        );

        /*
        1. Pronađite prosečnu cenu svih knjiga iz žanra "Fiction".
        2. Grupisanje knjiga po žanru i izračunavanje ukupne cene knjiga za svaki žanr.
        3. Kreirajte listu knjiga objavljenih pre 2000. godine, sortiranu po godini objavljivanja u rastućem redosledu.
        4. Pronađite sve autore koji imaju barem jednu knjigu iz žanra "Non-Fiction".
         */


        // 1.
        double avgPriceOfFiction =
                books.stream().filter(book -> book.getGenre().equalsIgnoreCase("fiction"))
                        .mapToDouble(Book::getPrice)
                        .average()
                        .orElse(0.0);

        System.out.println(avgPriceOfFiction);

        // 2.
        Map<String, List<Book>> booksByGenre =
                books.stream().collect(Collectors.groupingBy(Book::getGenre));

        Map<String, Double> sumByGenre =
                booksByGenre.entrySet().stream()
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        entry -> entry.getValue().stream().mapToDouble(Book::getPrice)
                                                .sum()
                                ));


        // 3.
        List<Book> before2000 =
                books.stream().filter(book -> book.getYearPublished() < 2000)
                                .sorted(Comparator.comparing(Book::getYearPublished))
                                        .toList();

        // 4.
        List<String> authorsNonFiction =
                books.stream().filter(book ->
                        book.getGenre().equalsIgnoreCase("non-fiction"))
                                .map(Book::getAuthor)
                                        .distinct()
                                                .toList();

        System.out.println();

    }
}
