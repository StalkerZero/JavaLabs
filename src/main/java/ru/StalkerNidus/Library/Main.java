package ru.StalkerNidus.Library;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("War and peace", "Tolstoy", 560);
        Book book3 = new Book("Diamond", "Keker", 120);
        Library library = new Library("Bibl", "фиг знает какой адрес");

        library.addBook(new Book("War and peace", "Tolstoy", 560));
        library.addBook(book1);
        library.addBook(book3);
        System.out.println(library.toString());

        System.out.println(library.takeBook("War and peace"));
        System.out.println(library.bookCount("War and peace"));

        System.out.println(library.hasBook("War and peace"));
        System.out.println(library.hasBook("Wa and peace"));
    }
}
