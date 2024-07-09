package org.example;
import org.example.models.Member;
import org.example.models.Book;
import org.example.service.Library;

public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        Book firstBook = new Book("1111", "maths", "gianna", 2001);
        Book secondBook = new Book("2222", "phy", "lisa", 2002);
        myLibrary.addBook(firstBook);
        myLibrary.addBook(secondBook);

        Member firstMember = new Member("1", "teta");
        Member secondMember = new Member("2", "keza");
        Member thirdMember = new Member("3", "linda");
        myLibrary.addMember(firstMember);
        myLibrary.addMember(secondMember);
        myLibrary.addMember(thirdMember);

        myLibrary.borrowBook("1", "1111");
        myLibrary.borrowBook("2", "2222");

        System.out.println("Available books: " + myLibrary.getAvailableBooks());
        System.out.println("Books borrowed by First Member: " + myLibrary.getBorrowedBooks(firstMember));

        myLibrary.returnBook("1", "1111");

        System.out.println("Available books after return: " + myLibrary.getAvailableBooks());
    }
}
