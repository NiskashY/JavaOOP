package com.company;

public class Book {
    public String book_title, author;

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String book_title, String author) {
        this.book_title = book_title;
        this.author = author;
    }
}
