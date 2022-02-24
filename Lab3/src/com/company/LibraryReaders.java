package com.company;

public class LibraryReaders {
    private String fio, faculty, birth_date, phone_number;
    private int library_card_number;

    public void setFio(String fio) {
        this.fio = fio;
    }

    private String findBookForm(int amount_of_taken_books) {
        if (amount_of_taken_books % 100 > 10 && amount_of_taken_books % 100 < 20
                || amount_of_taken_books % 10 == 0
                || amount_of_taken_books % 10 > 4) {
            return "книг";
        } else if (amount_of_taken_books % 10 == 1) {
            return "книгу";
        } else {
            return "книги";
        }
    }

    public void takeBook(int amount_of_taken_books) {
        System.out.println(fio + " взял " + amount_of_taken_books +
                " " + findBookForm(amount_of_taken_books));
    }

    public void takeBook(String... books_names) {
        System.out.print(fio + " взял: ");
        boolean first = true;
        for (String item : books_names) {
            if (!first) {
                System.out.print(", ");
            }
            first = false;
            System.out.print(item);
        }
        System.out.println();
    }

    public void takeBook(Book... books) {
        System.out.print(fio + " взял: ");
        boolean first = true;
        for (Book item : books) {
            if (!first) {
                System.out.print(", ");
            }
            first = false;
            System.out.print(item.book_title + "(автор - " + item.author + ")");
        }
        System.out.println();
    }

    public void returnBook(int amount_of_taken_books) {
        System.out.println(fio + " взял " + amount_of_taken_books +
                " " + findBookForm(amount_of_taken_books));
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setLibrary_card_number(int library_card_number) {
        this.library_card_number = library_card_number;
    }

    public String getFio() {
        return fio;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public int getLibrary_card_number() {
        return library_card_number;
    }

    public void returnBook(String... books_names) {
        System.out.print(fio + " взял: ");
        boolean first = true;
        for (String item : books_names) {
            if (!first) {
                System.out.print(", ");
            }
            first = false;
            System.out.print(item);
        }
        System.out.println();
    }

    public void returnBook(Book... books) {
        System.out.print(fio + " взял: ");
        boolean first = true;
        for (Book item : books) {
            if (!first) {
                System.out.print(", ");
            }
            first = false;
            System.out.print(item.book_title + "(автор - " + item.author + ")");
        }
        System.out.println();
    }
}
