package ru.StalkerNidus.FileLibrary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static void write(File file, Library lib) throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(lib.getId() + ";" + lib.getAddress() + ";");
            bw.newLine();
            for (Book b : lib.getBooks()) {
                bw.write(b.getId() + ";" + b.getTitle() + ";" + b.getAuthor() + ";" + b.getYear() + ";");
                bw.newLine();
            }
        }
    }

    public static Library read(File file) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            StringBuilder sb = new StringBuilder();
            String s;
            while((s = br.readLine()) != null) {
                sb.append(s);
            }
            String[] arr = sb.toString().split(";");
            List<Book> bookList = new ArrayList<>();
            for (int i = 2; i < arr.length-3; i+=4) {
                bookList.add(new Book(Integer.parseInt(arr[i]), arr[i+1], arr[i+2], Integer.parseInt(arr[i+3])));
            }
            return new Library(Integer.parseInt(arr[0]), arr[1], bookList);
        }
    }
}
