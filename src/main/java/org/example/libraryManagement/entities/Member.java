package org.example.libraryManagement.entities;

import org.example.libraryManagement.enums.BookStatus;
import org.example.libraryManagement.enums.MembershipType;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String memberId;
    private final String name;
    private final MembershipType membershipType;
    private final List<Book> borrowedBooks;

    public Member(String memberId, String name, MembershipType membershipType) {
        this.memberId = memberId;
        this.name = name;
        this.membershipType = membershipType;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", membershipType=" + membershipType +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
