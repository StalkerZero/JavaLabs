package ru.StalkerNidus.FileLibrary;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private int id;
    private String address;
    private List<Book> books;

    public Library(){books = new ArrayList<>();}

    public Library(int id, String address, List<Book> books) {
        this.id = id;
        this.address = address;
        this.books = books;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", books=" + books +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
