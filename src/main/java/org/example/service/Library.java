package org.example.service;
import org.example.models.Book;
import org.example.models.Member;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> inventory;
    private List<Member> users;

    public Library() {
        this.inventory = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        inventory.add(book);
    }

    public void addMember(Member member) {
        users.add(member);
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : inventory) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public List<Book> getBorrowedBooks(Member member) {
        return member.getBorrowed();
    }

    public boolean borrowBook(String memberId, String isbn) {
        Member member = findMemberById(memberId);
        Book book = findBookByIsbn(isbn);

        if (member != null && book != null) {
            return member.borrowBook(book);
        }
        return false;
    }

    public boolean returnBook(String memberId, String isbn) {
        Member member = findMemberById(memberId);
        Book book = findBookByIsbn(isbn);

        if (member != null && book != null) {
            return member.returnBook(book);
        }
        return false;
    }

    private Member findMemberById(String memberId) {
        for (Member member : users) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    private Book findBookByIsbn(String isbn) {
        for (Book book : inventory) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}
