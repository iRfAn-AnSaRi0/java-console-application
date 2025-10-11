package com.mycompany.app.dao;

import com.mycompany.app.model.Books;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mycompany.app.db.DbConnection;

public class BooksDAO {

    public void add_book(Books books) {
        String sql = "INSERT INTO books (book_name , book_author , copies_available) VALUES(?,?,?)";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, books.get_book_name());
            ps.setString(2, books.get_book_author());
            ps.setInt(3, books.get_copies_available());
            ps.executeUpdate();
            System.out.println("Book add successfully");
        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
    }

    public void delete_book(int id) {
        String sql = "DELETE FROM books WHERE book_id=?";

        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Book delete successfully");
        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
    }

    public void view_book() {
        String sql = "SELECT * FROM books";

        try (Connection con = DbConnection.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Books book = new Books(
                        rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getString("book_author"),
                        rs.getInt("copies_available"));
                System.err.println(book);
            }

        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
    }
}