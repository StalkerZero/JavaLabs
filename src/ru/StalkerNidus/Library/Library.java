package ru.StalkerNidus.Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private String title;
    private String address;
    private List<Book> books = new ArrayList<>(); //список со всеми книгами
    private Map<String, Integer> booksCache = new HashMap<>(); //ключ - название кники, объект - количество книг

    public Library(String title, String address) {
        this.title = title;
        this.address = address;
    }

    public boolean hasBook(String title){ return booksCache.containsKey(title);}

    public Book takeBook(String title){
        for (Book i : books){
            if (i.getTitle()==title){
                books.remove(i);
                if (booksCache.get(title)-1==0) booksCache.remove(title);
                else booksCache.replace(title, booksCache.get(title)-1);
                return i;
            }
        }
        return null;
    }

    public void addBook(Book book){
        books.add(book);
        if (hasBook(book.getTitle())) booksCache.replace(book.getTitle(), booksCache.get(book.getTitle())+1);
        else booksCache.put(book.getTitle(), 1);
    }

    public int bookCount(String title){
        for (String i : booksCache.keySet()){
            if (title==i) return booksCache.get(title);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Library{" +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", books=" + books +
                ", booksCache=" + booksCache +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Map<String, Integer> getBooksCache() {
        return booksCache;
    }

    public void setBooksCache(Map<String, Integer> booksCache) {
        this.booksCache = booksCache;
    }
}
