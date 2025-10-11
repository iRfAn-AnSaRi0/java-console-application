package com.mycompany.app.model;

public class Books {
    private int book_id;
    private String book_name;
    private String book_author;
    private int copies_available;

    // constructor for set the value
    public Books(String book_name, String book_author, int copies_available) {
        this.book_name = book_name;
        this.book_author = book_author;
        this.copies_available = copies_available;
    }

    // constructor for get the value
    public Books(int book_id, String book_name, String book_author, int copies_available) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.copies_available = copies_available;
    }

    // setter method
    public void setBook(String book_name, String book_author, int copies_available) {
        this.book_name = book_name;
        this.book_author = book_author;
        this.copies_available = copies_available;
    }

    // getter method

    public int get_book_id() {
        return book_id;
    }

    public String get_book_name() {
        return book_name;
    }

    public String get_book_author() {
        return book_author;
    }

    public int get_copies_available() {
        return copies_available;
    }

    @Override
    public String toString() {
        return "book_id : " + book_id + "book_name : " + book_name + "book_author : " + book_author
                + "copies_available : " + copies_available;
    }

}