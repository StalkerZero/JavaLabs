package ru.StalkerNidus.FileLibrary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
    Book
    - int id
    - String title
    - String author
    - int year
    Library
    - int id
    - String address
    - List<Book> books
    FileUtils
    - public static void write(File file, Library lib) throws IOException
    - public static Library read(File file) throws IOException
    в библиотеке будет 2 конструктора
    1 с инициализацией всех параметров из аргументов
    2 пустой, без аргументов
    вы создаете библиотеку используя 1 конструтор и сохраняете в файл через метод write
    после чего ваша задача получить новый объект библиотеки через метод read из файда
    1 строка файла это id и address разделенные ";"
    все остальные строчки это книги
    книги записывать тожно также, 1 строка = 1 книга, с полями разделенными ";"
    пример файла
        1;lib title
        1;book-1-title;book-1-author;2000
        2;book-2-title;book-2-author;2000
        3;book-3-title;book-3-author;2000
        4;book;4-title;book-4-author;2000
    String s = "123|456|789";
    String[] arr = s.split("|"); // ["123", "456", "789"]
 */
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "War", "Tolst", 1900));
        books.add(new Book(2, "Piece", "Tolst", 1900));
        books.add(new Book(3, "No", "Tolst", 1900));
        Library library = new Library(1, "adress", books);
        File file = new File("text.txt");
        double ms = System.currentTimeMillis();
        try {
            FileUtils.write(file, library);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(FileUtils.read(file).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-ms);
        ms=System.currentTimeMillis();
        try {
            FileUtils.write2(file, library);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(FileUtils.read2(file).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-ms);
    }
}
