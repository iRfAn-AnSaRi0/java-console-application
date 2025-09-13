package com.mycompany.app.model;

public class PartTimeEmployee extends Employee  {

     private double hourly_rate;
     private int hours_worked;

     public PartTimeEmployee(String emp_name, double hourly_rate, int hours_worked){
        super(emp_name, EmployeeType.PARTTIME);
        this.hourly_rate = hourly_rate;
        this.hours_worked = hours_worked;
     }

     public PartTimeEmployee(int emp_id, String emp_name, double hourly_rate, int hours_worked){
        super(emp_id, emp_name, EmployeeType.PARTTIME);
        this.hourly_rate = hourly_rate;
        this.hours_worked = hours_worked;
     }

      public double get_hourly_rate() {
        return hourly_rate;
    }

    public int get_hours_Worked() {
        return hours_worked;
    }

     @Override
     public String toString(){
        return super.toString() + "PartTimeEmployee [hourly_rate=" + hourly_rate +
                ", hours_worked=" + hours_worked + "]";
     }
} 
