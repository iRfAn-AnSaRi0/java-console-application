package com.mycompany.app.dao;

import java.sql.*;
import com.mycompany.app.db.DBConnection;
import com.mycompany.app.model.Employee;
import com.mycompany.app.model.EmployeeType;
import com.mycompany.app.model.FullTimeEmployee;
import com.mycompany.app.model.PartTimeEmployee;
import com.mycompany.app.model.Payroll;
import com.mycompany.app.service.PayrollService;

public class EmployeeDAO {

    /* Employee details APIs */

    public void emp_add(Employee employee) {
        String sql = "INSERT INTO emp_details (emp_name, emp_type) VALUES(?,?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, employee.get_emp_name());
            ps.setString(2, employee.get_emp_type().name());
            ps.executeUpdate();
            System.out.println("Employee added successfully");
        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
    }

    public void emp_delete(int id) {
        String sql1 = "DELETE FROM emp_details WHERE emp_id=?";
        String sql2 = "DELETE FROM emp_payroll WHERE emp_id=?";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps1 = con.prepareStatement(sql1)
                /*PreparedStatement ps2 = con.prepareStatement(sql2)*/) {
            ps1.setInt(1, id);
            // ps2.setInt(2, id);
            ps1.executeUpdate();
            // ps2.executeUpdate();
            System.out.println("employee details delete");

        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
    }

    public void emp_update(Employee employee) {
        String sql = "UPDATE emp_details SET emp_name=?, emp_type=? WHERE emp_id=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, employee.get_emp_name());
            ps.setString(2, employee.get_emp_type().name());
            ps.setInt(3, employee.get_emp_id());
            ps.executeUpdate();
            System.out.println("employee details updated");
        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }

    }

    public Employee emp_details(int id) {
        String sql = "SELECT * FROM emp_details WHERE emp_id=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet res = ps.executeQuery()) {
                if (res.next()) {
                   
                    return new Employee(
                            res.getInt("emp_id"),
                            res.getString("emp_name"),
                            EmployeeType.valueOf(res.getString("emp_type"))

                    );
                }
            }

        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
        return null;
    }

    public void view_all_emp() {
        String sql = "SELECT * FROM emp_details";
        try (Connection con = DBConnection.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
                    while(rs.next()){
                        Employee employee = new Employee(
                         rs.getInt("emp_id"),
                         rs.getString("emp_name"),
                         EmployeeType.valueOf(rs.getString("emp_type"))
                         );
                         System.out.println(employee);
                    }

        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }

    }

    /* Employee Payroll APIs */

    public void add_salary(){
        
    }
}
