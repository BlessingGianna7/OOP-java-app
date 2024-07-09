package org.example.models;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private List<Book> borrowed;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowed = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowed() {
        return borrowed;
    }

    public boolean borrowBook(Book book) {
        if (borrowed.size() < 5 && book.isAvailable()) {
            borrowed.add(book);
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (borrowed.remove(book)) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", borrowed=" + borrowed +
                '}';
    }
}
