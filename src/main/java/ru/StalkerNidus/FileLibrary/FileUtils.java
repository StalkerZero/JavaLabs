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

    public static void write2(File file, Library lib) throws IOException
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file)))
        {
            StringBuilder sb = new StringBuilder();
            sb.append(lib.getId()).append(";").append(lib.getAddress()).append("\n");
            for(Book b : lib.getBooks()) {
                sb.append(b.getId()).append(";")
                        .append(b.getTitle()).append(";")
                        .append(b.getAuthor()).append(";")
                        .append(b.getYear()).append("\n");
            }
            bw.write(sb.toString());
        }
    }

    public static Library read(File file) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String[] arr = br.toString().split(";");
            List<Book> bookList = new ArrayList<>();
            for (int i = 2; i < arr.length-3; i+=4) {
                bookList.add(new Book(Integer.parseInt(arr[i]), arr[i+1], arr[i+2], Integer.parseInt(arr[i+3])));
            }
            return new Library(Integer.parseInt(arr[0]), arr[1], bookList);
        }
    }

    public static Library read2(File file) throws Exception
    {
        if(!file.exists()) {
            return null;
        }

        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String[] arr = br.readLine().split(";");
            Library lib = new Library(Integer.parseInt(arr[0]), arr[1]);

            String s;
            while((s = br.readLine()) != null) {
                arr = s.split(";");
                lib.getBooks().add(new Book(
                        Integer.parseInt(arr[0]),
                        arr[1],
                        arr[2],
                        Integer.parseInt(arr[3])
                ));
            }

            return lib;
        }
    }
}
