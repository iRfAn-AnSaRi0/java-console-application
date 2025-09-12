package com.mycompany.app.dao;

import java.sql.*;
import com.mycompany.app.db.DBConnection;
import com.mycompany.app.model.Student;;

public class StudentDAO {

    public void std_details_add(Student student) {
        String sql = "INSERT INTO std_details (std_name, std_email, std_phone, std_dob, std_address) VALUES(?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, student.get_name());
            ps.setString(2, student.get_email());
            ps.setString(3, student.get_phone());
            ps.setDate(4, student.get_dob());
            ps.setString(5, student.get_address());
            ps.executeUpdate();
            System.out.println("Student details added");
        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
    }

    public void std_details_read_all() {
        String sql = "SELECT * FROM std_details";
        try (Connection con = DBConnection.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("std_id"),
                        rs.getString("std_name"),
                        rs.getString("std_email"),
                        rs.getString("std_phone"),
                        rs.getDate("std_dob"),
                        rs.getString("std_address"));
                System.out.println(student);
            }

        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
    }

    public void std_details_update(Student student) {
        String sql = "UPDATE std_details std_name=?, std_email=?, std_phone=?, std_dob=?, std_address=? WHERE std_id=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, student.get_name());
            ps.setString(2, student.get_email());
            ps.setString(3, student.get_phone());
            ps.setDate(4, student.get_dob());
            ps.setString(5, student.get_address());
            ps.setInt(6, student.get_id());
            ps.executeUpdate();
            System.out.println("Student details updated");
        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
    }

    public void std_details_delete(int id) {
        String sql = "DELETE FROM std_Details WHERE std_id=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student deleted");
        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
    }

    public Student std_Details_read(int id) {
        String sql = "SELECT * FROM std_details WHERE std_id=?";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getInt("std_id"),
                            rs.getString("std_name"),
                            rs.getString("std_email"),
                            rs.getString("std_phone"),
                            rs.getDate("std_dob"),
                            rs.getString("std_address"));
                }
            }

        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
        return null;
    }
}
