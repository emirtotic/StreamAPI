package com.streamApi.practice.books;

public class Book {

    private String title;
    private String author;
    private double price;
    private String genre; // "Fiction", "Non-Fiction", "Science Fiction", "Biography", itd.
    private int yearPublished;

    public Book(String title, String author, double price, String genre, int yearPublished) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.genre = genre;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                ", yearPublished=" + yearPublished +
                '}';
    }

}
