package com.mycompany.app.model;

public class FullTimeEmployee extends Employee {

    private double base_salary;
    private double bonus;
    private double tax_rate;

    public FullTimeEmployee(String emp_name, double base_salary, double bonus, double tax_rate) {
        super(emp_name, EmployeeType.FULLTIME);
        this.base_salary = base_salary;
        this.bonus = bonus;
        this.tax_rate = tax_rate;
    }

    public FullTimeEmployee(int emp_id, String emp_name, double base_salary, double bonus, double tax_rate) {
        super(emp_id, emp_name, EmployeeType.FULLTIME);
        this.base_salary = base_salary;
        this.bonus = bonus;
        this.tax_rate = tax_rate;
    }

    public double get_base_salary() {
        return base_salary;
    }

    public double get_bonus() {
        return bonus;
    }

    public double get_tax_rate() {
        return tax_rate;
    }

    @Override
    public String toString() {
        return super.toString() + "FullTimeEmployee [base_salary = " + base_salary + ", bonus = " + bonus +
                ", tax_rate = " + tax_rate + "]";
    }
}
