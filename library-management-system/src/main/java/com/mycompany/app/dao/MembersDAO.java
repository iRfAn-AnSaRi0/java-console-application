package com.mycompany.app.dao;

import com.mycompany.app.model.Members;
import com.mycompany.app.db.DbConnection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MembersDAO {

    public void add_member(Members members) {
        String sql = "INSERT INTO member (member_name, member_email, member_phone) VALUES(?,?,?)";

        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, members.get_member_name());
            ps.setString(2, members.get_member_email());
            ps.setString(3, members.get_member_phone());
            ps.executeUpdate();
            System.out.println("Member add successfully");
        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
    }

    public void delete_member(int id) {
        String sql = "DELETE FROM member WHERE member_id=?";

        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Member delete successfully");
        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
    }

    public void view_member() {
        String sql = "SELECT * FROM member";
        try (Connection con = DbConnection.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Members members = new Members(
                        rs.getInt("member_id"),
                        rs.getString("member_name"),
                        rs.getString("member_email"),
                        rs.getString("member_phone"),
                        rs.getInt("member_issued_books"));
                System.out.println(members);
            }

        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
    }

    public void update_member(Members members) {
        String sql = "UPDATE member SET member_name=?, member_email=?, member_phone=? WHERE member_id=?";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, members.get_member_name());
            ps.setString(2, members.get_member_email());
            ps.setString(3, members.get_member_phone());
            ps.setInt(4, members.get_member_id());
            ps.executeUpdate();
            System.out.println("Members details update successfully");
        } catch (Exception e) {
            System.err.println("Server error");
            e.printStackTrace();
        }
    }
}