package com.mycompany.app.dao;

import com.mycompany.app.model.IssuedBooks;
import com.mycompany.app.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class IssuedBooksDAO {

    public void return_date(IssuedBooks issuedBooks) {
        String sql = "UPDATE issued_book SET retrun_date=? WHERE member_id=?";

        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, issuedBooks.get_return_date());
            ps.setInt(2, issuedBooks.get_member_id());
            ps.executeUpdate();
            System.out.println("Return book successfully");
        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
    }
}