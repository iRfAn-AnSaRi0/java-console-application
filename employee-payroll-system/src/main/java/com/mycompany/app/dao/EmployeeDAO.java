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

    public void emp_add(String name, EmployeeType type){
        String sql = "INSERT INTO emp_details (emp_name, emp_type) VALUES(?,?)";
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
             ps.setString(1, name);
             ps.setString(2, type.name());
             ps.executeUpdate();
             System.out.println("Employee added successfully");
        } catch (Exception e) {
            System.out.println("Server error");
            e.printStackTrace();
        }
    }
}