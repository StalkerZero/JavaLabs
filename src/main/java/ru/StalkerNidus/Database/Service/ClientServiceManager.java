package ru.StalkerNidus.Database.Service;

import ru.StalkerNidus.Database.Book.Application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientServiceManager {

    public static List<ClientServiceJoin> join() throws SQLException {
        try(Connection c = Main.getConnection()){
            String sql = """
                    SELECT cs.ID, Title, Cost, FirstName, LastName, Patronymic, StartTime FROM clientservice as cs 
                    INNER JOIN client ON ClientID=client.ID
                    INNER JOIN service ON ServiceID=service.ID
                     """;
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);
            List<ClientServiceJoin> list = new ArrayList<>();
            while(resultSet.next()){
                list.add(new ClientServiceJoin(
                        resultSet.getInt("ID"),
                        resultSet.getString("Title"),
                        resultSet.getDouble("Cost"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Patronymic"),
                        resultSet.getTimestamp("StartTime")
                ));
            }
            return list;
        }
    }

    public static void setComment(String FirstName, String LastName, String Patronymic, String Title, String Comment) throws SQLException {
        try(Connection c = Main.getConnection()) {
            String sql = """
                    UPDATE clientservice SET Comment=?
                    WHERE ClientID = (SELECT ID FROM client WHERE FirstName=? AND LastName=? AND Patronymic=?) 
                    AND ServiceID = (SELECT ID FROM service WHERE Title=?)
                    """;
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, Comment);
            ps.setString(2, FirstName);
            ps.setString(3, LastName);
            ps.setString(4, Patronymic);
            ps.setString(5, Title);

            ps.executeUpdate();
        }
    }
}
