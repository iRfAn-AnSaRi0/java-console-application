package com.mycompany.app.dao;

import com.mycompany.app.model.IssuedBooks;
import com.mycompany.app.db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class IssuedBooksDAO {

    // Issued book Quary
    public void issued_book(IssuedBooks issuedBooks) {
        String sql1 = "SELECT copies_available FROM books WHERE book_id=?";
        // Issued booked Query
        String sql2 = "INSERT INTO issued_books (member_id, book_id) VALUES(?,?)";
        // Update member table Query
        String sql3 = "UPDATE members SET member_issued_books = member_issued_books + 1 WHERE member_id = ?";
        // Update book table Query
        String sql4 = "UPDATE books SET copies_available = copies_available - 1 WHERE book_id = ?";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps1 = con.prepareStatement(sql1)) {
            // Checking book id is valid or not and number of copies available of book
            ps1.setInt(1, issuedBooks.get_book_id());
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                int number_of_copies = rs.getInt("copies_available");
                if (number_of_copies <= 0) {
                    System.out.println("No copies is available");
                    return;
                }
            } else {
                System.out.println("Book ID not found!");
                return;
            }

            // Issued booked
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, issuedBooks.get_member_id());
            ps2.setInt(2, issuedBooks.get_book_id());
            ps2.executeUpdate();
            System.out.println("Booked issued");

            // Update member table
            PreparedStatement ps3 = con.prepareStatement(sql3);
            ps3.setInt(1, issuedBooks.get_member_id());
            ps3.executeUpdate();

            // Update book table
            PreparedStatement ps4 = con.prepareStatement(sql4);
            ps4.setInt(1, issuedBooks.get_book_id());
            ps4.executeUpdate();

        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
    }

    // Return book Quary
    public void retrun_book(IssuedBooks issuedBooks) {
        String sql1 = "SELECT issued_id FROM issued_books WHERE member_id=? AND book_id=? AND return_date IS NULL";
        String sql2 = "UPDATE issued_books SET return_date = CURRENT_DATE WHERE book_id = ? AND member_id = ? AND return_date IS NULL";
        String sql3 = "UPDATE books SET copies_available = copies_available + 1 WHERE book_id = ?";
        String sql4 = "UPDATE members SET member_issued_books = member_issued_books - 1 WHERE member_id = ? AND member_issued_books > 0";

        try (Connection con = DbConnection.getConnection(); PreparedStatement ps1 = con.prepareStatement(sql1)) {
            ps1.setInt(1, issuedBooks.get_member_id());
            ps1.setInt(2, issuedBooks.get_book_id());
            ResultSet rs = ps1.executeQuery();
            if (!rs.next()) {
                System.out.println("Invalid return: Book not issued or already returned.");
                return;
            }
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, issuedBooks.get_book_id());
            ps2.setInt(2, issuedBooks.get_member_id());
            ps2.executeUpdate();
            System.out.println("Book was return");

            PreparedStatement ps3 = con.prepareStatement(sql3);
            ps3.setInt(1, issuedBooks.get_book_id());
            ps3.executeUpdate();

            PreparedStatement ps4 = con.prepareStatement(sql4);
            ps4.setInt(1, issuedBooks.get_member_id());
            ps4.executeUpdate();

        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }

    }

    // Show all issued book
    public void get_all_issued_books_details() {
        String sql = "SELECT * FROM issued_books";

        try (Connection con = DbConnection.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                IssuedBooks issuedBooks = new IssuedBooks(
                        rs.getInt("issued_id"),
                        rs.getInt("member_id"),
                        rs.getInt("book_id"),
                        rs.getDate("issued_date"),
                        rs.getDate("return_date"));
                System.out.println(issuedBooks);
            }
        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
    }
}
