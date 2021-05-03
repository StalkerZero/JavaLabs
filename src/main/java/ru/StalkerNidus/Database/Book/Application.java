package ru.StalkerNidus.Database.Book;

import static ru.StalkerNidus.Database.Book.BookEntityManager.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application
{

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void main(String[] args) throws SQLException, ParseException
    {
        /*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //System.out.println(format.format(new Date()));
        String dateString = "2021-04-23 05:46:25";
        try {
            Date date = format.parse(dateString);
            System.out.println(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //Scanner scanner = new Scanner(System.in);

        /*dropTable();
        createTable();
        insert(new BookEntity("eoiwfjwoeifhewf", "qwepfjwqfwq", 232, new Date(), 56.3, 33));
        System.out.println(getAll());*/

        /*BookEntity b1 = getById(1);
        System.out.printf("Введите новую дату (yyyy-MM-dd hh:mm:ss): ");
        b1.setCreateDate(format.parse(scanner.nextLine()));
        update(b1);*/

        run();
    }

    public static void run() throws SQLException, ParseException {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.printf("""
                Выберите действие:
                1 - Вывести все 
                2 - Вывести по id
                3 - Добавить
                4 - Редактировать
                5 - Удалить
                0 - Выход
                """
            );
            int i = Integer.parseInt(scanner.nextLine());

            switch (i)
            {
                case 1:
                    System.out.println(getAll());
                    break;
                case 2: {
                    System.out.printf("Введите id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println(getById(id));
                    break;
                }
                case 3: {
                    System.out.printf("Введите название: ");
                    String title = scanner.nextLine();
                    System.out.printf("Введите автора: ");
                    String author = scanner.nextLine();
                    System.out.printf("Введите количество страниц: ");
                    int pages = Integer.parseInt(scanner.nextLine());
                    System.out.printf("Введите дату написания (yyyy-MM-dd hh:mm:ss): ");
                    Date createDate = DATE_FORMAT.parse(scanner.nextLine());
                    System.out.printf("Введите рейтинг: ");
                    double rating = Double.parseDouble(scanner.nextLine());
                    System.out.printf("Введите возрастное ограничение: ");
                    int ageRating = Integer.parseInt(scanner.nextLine());

                    insert(new BookEntity(title, author, pages, createDate, rating, ageRating));
                    break;
                }
                case 4: {
                    System.out.printf("Введите id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    BookEntity book = getById(id);
                    if(book == null) {
                        System.out.println("Такой книги не существует");
                        continue;
                    }

                    System.out.printf("Введите название: ");
                    String title = scanner.nextLine();
                    System.out.printf("Введите автора: ");
                    String author = scanner.nextLine();
                    System.out.printf("Введите количество страниц: ");
                    int pages = Integer.parseInt(scanner.nextLine());
                    System.out.printf("Введите дату написания (yyyy-MM-dd hh:mm:ss): ");
                    Date createDate = DATE_FORMAT.parse(scanner.nextLine());
                    System.out.printf("Введите рейтинг: ");
                    double rating = Double.parseDouble(scanner.nextLine());
                    System.out.printf("Введите возрастное ограничение: ");
                    int ageRating = Integer.parseInt(scanner.nextLine());

                    /*book.setTitle(title);
                    book.setAuthor(author);
                    book.setPages(pages);
                    book.setCreateDate(createDate);
                    book.setRating(rating);
                    book.setAgeRating(ageRating);*/

                    book.setTitle(title)
                            .setAuthor(author)
                            .setPages(pages)
                            .setCreateDate(createDate)
                            .setRating(rating)
                            .setAgeRating(ageRating);

                    update(book);

                    break;
                }
                case 5: {
                    System.out.printf("Введите id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    deleteById(id);
                }
                break;
                case 0:
                    System.out.println("Конец");
                    return;

            }
        }
    }

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3305/java_book",
                "root",
                "0000"
        );
    }
}
