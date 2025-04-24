package org.example.libraryManagement.entities;

import org.example.libraryManagement.enums.BookStatus;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final int publicationYear;
    private BookStatus bookStatus;

    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn=isbn;
        this.title=title;
        this.author=author;
        this.publicationYear=publicationYear;
        this.bookStatus=BookStatus.AVAILABLE;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus=bookStatus;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + publicationYear + ") - " + bookStatus;
    }
}
