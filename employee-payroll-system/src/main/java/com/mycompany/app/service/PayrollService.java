package com.mycompany.app.service;

import com.mycompany.app.model.FullTimeEmployee;
import com.mycompany.app.model.PartTimeEmployee;
import java.math.BigDecimal;

public class PayrollService {

    // FULL-TIME EMPLOYEE

    public BigDecimal calculate_salary(FullTimeEmployee emp) {

        BigDecimal gross_salary = BigDecimal.valueOf(emp.get_base_salary()).add(BigDecimal.valueOf(emp.get_bonus()));

        BigDecimal total_tax = gross_salary.multiply(BigDecimal.valueOf(emp.get_tax_rate()))
                .divide(BigDecimal.valueOf(100));

        return gross_salary.subtract(total_tax);
    }


    // PART-TIME EMPLOYEE

    public BigDecimal calculate_salary(PartTimeEmployee emp) {
        BigDecimal gross_salary = BigDecimal.valueOf(emp.get_hourly_rate())
                .multiply(BigDecimal.valueOf(emp.get_hours_Worked()));
        return gross_salary;
    }

    public void printPayrollInfo(String name, BigDecimal netSalary) {
        System.out.println("Employee: " + name + ", Net Salary: " + netSalary);
    }
}