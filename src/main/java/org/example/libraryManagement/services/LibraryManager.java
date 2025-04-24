package org.example.libraryManagement.services;

import org.example.libraryManagement.entities.Book;
import org.example.libraryManagement.entities.Member;
import org.example.libraryManagement.enums.BookStatus;

import java.util.HashMap;
import java.util.Map;

public class LibraryManager {

    private final Map<String, Book> books;
    private final Map<String, Member> members;

    public LibraryManager() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void registerMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public boolean borrowBook(String memberId, String isbnId) {
        Member member = members.get(memberId);
        Book book = books.get(isbnId);

        if (member == null || book == null) {
            System.out.println("Invalid member or book");
            return false;
        }

        if (book.getBookStatus() != BookStatus.AVAILABLE) {
            System.out.println("Book is not available");
            return false;
        }

        book.setBookStatus(BookStatus.BORROWED);
        member.borrowBook(book);
        return true;
    }

    public boolean returnBook(String memberId, String isbnId) {
        Member member = members.get(memberId);
        Book book = books.get(isbnId);

        if (book == null || member == null || !member.getBorrowedBooks().contains(book)) {
            System.out.println("Invalid return");
            return false;
        }

        book.setBookStatus(BookStatus.AVAILABLE);
        member.returnBook(book);
        return true;
    }


    public void searchBooks(String keyword) {
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
            }
        }
    }

    public void showAllBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

}
