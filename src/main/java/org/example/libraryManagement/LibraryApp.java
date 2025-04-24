package org.example.libraryManagement;

import org.example.libraryManagement.entities.Book;
import org.example.libraryManagement.entities.Member;
import org.example.libraryManagement.enums.MembershipType;
import org.example.libraryManagement.services.LibraryManager;

public class LibraryApp {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        manager.addBook(new Book("ISBN001", "Effective Java", "Joshua", 2018));
        manager.addBook(new Book("ISBN002", "Clean code", "Rober", 2019));

        manager.registerMember(new Member("M001", "Alice", MembershipType.REGULAR));
        manager.registerMember(new Member("M002", "Bob", MembershipType.PREMIUM));

        manager.borrowBook("M001", "ISBN002");
        manager.returnBook("M001", "ISBN002");

        System.out.println("\nSearch results for 'code':");
        manager.searchBooks("code");

        System.out.println("\nAll books:");
        manager.showAllBooks();

    }
}
