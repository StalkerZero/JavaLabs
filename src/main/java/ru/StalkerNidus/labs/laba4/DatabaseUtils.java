package ru.StalkerNidus.labs.laba4;

import java.sql.*;

public class DatabaseUtils {
    public static void createTableEntity() throws SQLException{
        try (Connection c = getConnection()) {
            Statement s = c.createStatement();
            String sql ="""
                    CREATE TABLE IF NOT EXISTS entity (
                        id BIGINT NOT NULL AUTO_INCREMENT,
                        title VARCHAR(128) NOT NULL,
                        date_and_time_creation DATETIME NOT NULL,
                        date_and_time_death DATETIME NULL,
                        PRIMARY KEY(id)
                    );
                    """;
            s.executeUpdate(sql);
        }
    }

    public static long insertEntity(String title) throws SQLException {
        try (Connection c = getConnection()) {
            String sql ="INSERT INTO entity(title, date_and_time_creation) VALUES(?, current_timestamp());";
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, title);
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            keys.next();
            return keys.getLong(1);
        }
    }

    public static void updateEntity(long id) throws SQLException{
        try (Connection c = getConnection()) {
            String sql ="UPDATE entity SET date_and_time_death=current_timestamp() WHERE id=?;";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }

    public static void createTablePlayer() throws SQLException{
        try (Connection c = getConnection()) {
            String sql ="""
                    CREATE TABLE IF NOT EXISTS player (
                        id BIGINT NOT NULL,
                        nickname VARCHAR(128) NOT NULL,
                        xp DOUBLE(10, 2) NOT NULL,
                        FOREIGN KEY (id) REFERENCES entity (id)
                    );
                    """;
            Statement s = c.createStatement();
            s.executeUpdate(sql);
        }
    }

    public static void insertPlayer(long id, String nickname, double xp) throws SQLException {
        try (Connection c = getConnection()) {
            String sql ="INSERT INTO player VALUES(?, ?, ?);";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, id);
            ps.setString(2, nickname);
            ps.setDouble(3, xp);
            ps.executeUpdate();
        }
    }

    public static void updatePlayer(long id, double xp) throws SQLException {
        try (Connection c = getConnection()) {
            String sql ="UPDATE player SET xp=? WHERE id=?;";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setDouble(1, xp);
            ps.setLong(2, id);
            ps.executeUpdate();
        }
    }

    public static long selectIDPlayer(String nickname) throws SQLException{
        try (Connection c = getConnection()) {
            String sql ="SELECT id FROM player WHERE nickname=?;";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nickname);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) return resultSet.getLong(1);
            return 0;
        }
    }

    public static double selectXPPlayer(String nickname) throws SQLException{
        try (Connection c = getConnection()) {
            String sql ="SELECT xp FROM player WHERE nickname=?;";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nickname);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) return resultSet.getDouble(1);
            return 0;
        }
    }

    public static void createTableLogs() throws SQLException{
        try (Connection c = getConnection()) {
            String sql ="""
                    CREATE TABLE IF NOT EXISTS logs (
                        id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        id_attacker BIGINT NOT NULL,
                        id_attacked BIGINT NOT NULL,
                        date_and_time_kill DATETIME NOT NULL,
                        FOREIGN KEY (id_attacker) REFERENCES entity (id),
                        FOREIGN KEY (id_attacked) REFERENCES entity (id)
                    );
                    """;
            Statement s = c.createStatement();
            s.executeUpdate(sql);
        }
    }

    public static void insertLogs(long id_attacker, long id_attacked) throws SQLException {
        try (Connection c = getConnection()) {
            String sql ="INSERT INTO logs(id_attacker, id_attacked, date_and_time_kill) VALUES(?, ?, current_timestamp());";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, id_attacker);
            ps.setLong(2, id_attacked);
            ps.executeUpdate();
        }
    }

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3305/gameserver",
                "root",
                "0000"
        );
    }
}
