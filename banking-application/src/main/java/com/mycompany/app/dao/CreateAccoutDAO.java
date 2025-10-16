package com.mycompany.app.dao;

import com.mycompany.app.model.CreateAccount;
import com.mycompany.app.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreateAccoutDAO {
    public void create_account(CreateAccount createAccount) {
        String sql = "INSERT INTO create_account(account_number, ifc_code, account_holder_name, account_holder_phone, account_balance, account_status, account_create_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, createAccount.get_account_number()); 
            ps.setString(2, createAccount.get_ifc_code()); 
            ps.setString(3, createAccount.get_account_holder_name()); 
            ps.setString(4, createAccount.get_account_holder_phone());
            ps.setDouble(5, createAccount.get_account_balance()); 
            ps.setString(6, createAccount.get_account_status()); 
            ps.setTimestamp(7, new java.sql.Timestamp(createAccount.get_account_create_date().getTime()));
            ps.executeUpdate();
            System.out.println("Account created");
        } catch (Exception e) {
            System.err.println("Server error");
            e.printStackTrace();
        }
    }

    public void update_account_details(CreateAccount createAccount) {
        String sql = "UPDATE create_account SET account_holder_name = ? , account_holder_phone = ? WHERE account_number=?";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, createAccount.get_account_holder_name());
            ps.setString(2, createAccount.get_account_holder_phone());
            ps.setLong(3, createAccount.get_account_number());
            ps.executeUpdate();
            System.out.println("Account details updated");
        } catch (Exception e) {
            System.err.println("Server error");
            e.printStackTrace();
        }
    }

    public void view_account_info(CreateAccount createAccount) {
        String sql = "SELECT * FROM create_account WHERE account_number=?";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, createAccount.get_account_number());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("===== Account Information =====");
                System.out.println("Account Number   : " + rs.getLong("account_number"));
                System.out.println("Account Holder   : " + rs.getString("account_holder_name"));
                System.out.println("Phone Number     : " + rs.getString("account_holder_phone"));
                System.out.println("IFSC Code        : " + rs.getString("ifc_code"));
                System.out.println("Balance          : " + rs.getDouble("account_balance"));
                System.out.println("Created On       : " + rs.getDate("account_create_date"));
                System.out.println("Status           : " + rs.getString("account_status"));
                System.out.println("================================");
            } else {
                System.out.println("❌ Invalid account number. Please check and try again.");
            }
        } catch (Exception e) {
            System.err.println("Server error");
            e.printStackTrace();
        }
    }
}
