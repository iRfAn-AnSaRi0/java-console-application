package com.mycompany.app.dao;

import java.sql.*;
import com.mycompany.app.db.DBConnection;

import com.mycompany.app.model.Payroll;

public class PayrollDAO {
    
     public void addPayroll(Payroll payroll) {
        String sql = "INSERT INTO emp_payroll (emp_id, base_salary, hours_worked, bonus, tax_rate) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, payroll.get_emp_id());
            ps.setBigDecimal(2, payroll.get_base_salary());
            ps.setInt(3, payroll.get_hours_worked());
            ps.setBigDecimal(4, payroll.get_bonus());
            ps.setBigDecimal(5, payroll.get_tax_rate());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Payroll added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error while adding payroll: " + e.getMessage());
        }
    }

    // 2️⃣ Read Payroll by Employee ID
    public Payroll getPayrollByEmpId(int emp_id) {
        String sql = "SELECT * FROM emp_payroll WHERE emp_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, emp_id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Payroll(
                            rs.getInt("payroll_id"),
                            rs.getInt("emp_id"),
                            rs.getBigDecimal("base_salary"),
                            rs.getInt("hours_worked"),
                            rs.getBigDecimal("bonus"),
                            rs.getBigDecimal("tax_rate")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Error while fetching payroll: " + e.getMessage());
        }
        return null;
    }

    // 3️⃣ Update Payroll Record
    public void updatePayroll(Payroll payroll) {
        String sql = "UPDATE emp_payroll SET base_salary=?, hours_worked=?, bonus=?, tax_rate=? WHERE emp_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setBigDecimal(1, payroll.get_base_salary());
            ps.setInt(2, payroll.get_hours_worked());
            ps.setBigDecimal(3, payroll.get_bonus());
            ps.setBigDecimal(4, payroll.get_tax_rate());
            ps.setInt(5, payroll.get_emp_id());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Payroll updated successfully!");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error while updating payroll: " + e.getMessage());
        }
    }

    // 4️⃣ Delete Payroll Record by Employee ID
    public void deletePayrollByEmpId(int emp_id) {
        String sql = "DELETE FROM emp_payroll WHERE emp_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, emp_id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Payroll deleted successfully!");
            } else {
                System.out.println("⚠️ No payroll found for given employee ID.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error while deleting payroll: " + e.getMessage());
        }
    }
}
