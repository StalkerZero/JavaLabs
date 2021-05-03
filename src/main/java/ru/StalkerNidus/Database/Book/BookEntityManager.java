package ru.StalkerNidus.Database.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookEntityManager
{
    public static void createTable() throws SQLException
    {
        try(Connection c = Application.getConnection())
        {
            /*String sql = "CREATE TABLE IF NOT EXISTS books (" +
                    "id INT(10) NOT NULL AUTO_INCREMENT," +
                    "title VARCHAR(128) NOT NULL," +
                    "author VARCHAR(128) NOT NULL," +
                    "pages INT(5) NOT NULL," +
                    "PRIMARY KEY(id)" +
                    ")";*/

            String sql = """
                    CREATE TABLE IF NOT EXISTS books (
                        id INT(10) NOT NULL AUTO_INCREMENT,
                        title VARCHAR(128) NOT NULL,
                        author VARCHAR(128) NOT NULL,
                        pages INT(5) NOT NULL,
                        create_date DATETIME NOT NULL,
                        rating DOUBLE(5,2) DEFAULT 0,
                        age_rating INT(3) DEFAULT 12,
                        PRIMARY KEY(id)
                    );
                    """;

            Statement s = c.createStatement();

            s.executeUpdate(sql);
        }
    }

    public static void dropTable() throws SQLException
    {
        try(Connection c = Application.getConnection())
        {
            String sql = "DROP TABLE IF EXISTS books";
            Statement s = c.createStatement();
            s.executeUpdate(sql);
        }
    }

    public static void insert(BookEntity book) throws SQLException
    {
        try(Connection c = Application.getConnection())
        {
            String sql = "INSERT INTO books(title, author, pages, create_date, rating, age_rating) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPages());
            ps.setTimestamp(4, new Timestamp(book.getCreateDate().getTime()));
            ps.setDouble(5, book.getRating());
            ps.setInt(6, book.getAgeRating());

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next()) {
                book.setId(keys.getInt(1));
                return;
            }

            throw new SQLException("Entity not added. DB return no keys.");
        }
    }

    public static BookEntity getById(int id) throws SQLException
    {
        try(Connection c = Application.getConnection())
        {
            String sql = "SELECT * FROM books WHERE id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                return new BookEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getInt("pages"),
                        resultSet.getTimestamp("create_date"),
                        resultSet.getDouble("rating"),
                        resultSet.getInt("age_rating")
                );
            }

            return null;
        }
    }

    public static List<BookEntity> getAll() throws SQLException
    {
        try(Connection c = Application.getConnection())
        {
            String sql = "SELECT * FROM books";
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            List<BookEntity> list = new ArrayList<>();
            while(resultSet.next()) {
                list.add(new BookEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getInt("pages"),
                        resultSet.getTimestamp("create_date"),
                        resultSet.getDouble("rating"),
                        resultSet.getInt("age_rating")
                ));
            }
            return list;
        }
    }

    public static void update(BookEntity book) throws SQLException
    {
        try(Connection c = Application.getConnection())
        {
            String sql = "UPDATE books SET title=?, author=?, pages=?, create_date=?, rating=?, age_rating=? WHERE id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPages());
            ps.setTimestamp(4, new Timestamp(book.getCreateDate().getTime()));
            ps.setDouble(5, book.getRating());
            ps.setInt(6, book.getAgeRating());
            ps.setInt(7, book.getId());

            ps.executeUpdate();
        }
    }

    public static void deleteById(int id) throws SQLException
    {
        try(Connection c = Application.getConnection())
        {
            String sql = "DELETE FROM books WHERE id=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
