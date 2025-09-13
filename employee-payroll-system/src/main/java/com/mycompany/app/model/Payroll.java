package com.mycompany.app.model;

import java.math.BigDecimal;

public class Payroll {
    private int payroll_id;
    private int emp_id;
    private BigDecimal base_salary;
    private int hours_worked;
    private BigDecimal bonus;
    private BigDecimal tax_rate;

    public Payroll(BigDecimal base_salary, int hours_worked, BigDecimal bonus, BigDecimal tax_rate) {
        this.base_salary = base_salary;
        this.hours_worked = hours_worked;
        this.bonus = bonus;
        this.tax_rate = tax_rate;
    }

    public Payroll(int payroll_id, int emp_id, BigDecimal base_salary, int hours_worked, BigDecimal bonus,
            BigDecimal tax_rate) {
        this.payroll_id = payroll_id;
        this.emp_id = emp_id;
        this.base_salary = base_salary;
        this.hours_worked = hours_worked;
        this.bonus = bonus;
        this.tax_rate = tax_rate;
    }

    public void setPayrollDetails(BigDecimal base_salary, int hours_worked, BigDecimal bonus, BigDecimal tax_rate) {
        this.base_salary = base_salary;
        this.hours_worked = hours_worked;
        this.bonus = bonus;
        this.tax_rate = tax_rate;
    }

    public int get_payroll_id(){
        return payroll_id;
    }
    public int get_emp_id(){
        return emp_id;
    }
    public BigDecimal get_base_salary(){
        return base_salary;
    }
    public int get_hours_worked(){
        return hours_worked;
    }
    public BigDecimal get_bonus(){
        return bonus;
    }
    public BigDecimal get_tax_rate(){
        return tax_rate;
    }

    @Override
    public String toString(){
        return "Payroll [payroll_id=" + payroll_id + ", emp_id=" + emp_id +
               ", base_salary=" + base_salary + ", hours_worked=" + hours_worked +
               ", bonus=" + bonus + ", tax_rate=" + tax_rate + "]";
    }
}
