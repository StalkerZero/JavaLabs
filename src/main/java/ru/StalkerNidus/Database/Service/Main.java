package ru.StalkerNidus.Database.Service;

import java.sql.*;
import static ru.StalkerNidus.Database.Service.ClientServiceManager.*;

public class Main {

    /*
        вывести в консоль список оказанных услуг со следующими полями
        - id записи (об оказании услуги)
        - название и стоимость услуги
        - ФИО клиента
        - дату начала
     */

    public static void main(String[] args) throws SQLException {
        /*for (ClientServiceJoin i : join()){
            System.out.println(i.toString() + "\n");
        }*/
        setComment("Варлам", "Некрасов", "Михайлович", "Замена подшипника компрессора кондиционера", "Добавил коммент");
    }

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3305/java",
                "root",
                "0000"
        );
    }
}
