package com.mycompany.app.model;

public class Employee {
    private int emp_id;
    private String emp_name;
    private EmployeeType emp_type;

    public Employee(String emp_name, EmployeeType emp_type) {
        this.emp_name = emp_name;
        this.emp_type = emp_type;
    }

    public Employee(int emp_id, String emp_name, EmployeeType emp_type) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_type = emp_type;
    }

    public void setEmployeeDetails(String emp_name, EmployeeType emp_type) {
        this.emp_name = emp_name;
        this.emp_type = emp_type;
    }

    public int get_emp_id(){
        return emp_id;
    }
    public String get_emp_name(){
        return emp_name;
    }
    public EmployeeType get_emp_type(){
        return emp_type;
    }

    @Override
    public String toString(){
        return "Student [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_type=" + emp_type +"]";
    }

}