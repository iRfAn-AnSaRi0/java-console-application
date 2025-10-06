package com.mycompany.app;

import com.mycompany.app.dao.*;
import com.mycompany.app.model.Employee;
import com.mycompany.app.model.EmployeeType;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("Select options");
            System.out.println("1. Add new employee");
            System.out.println("2. Add employee salary");
            System.out.println("3. Exit");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    boolean innerflag = true;
                    while (innerflag) {
                        System.out.println("\n--- Employee Management ---");
                        System.out.println("1. Add Employee");
                        System.out.println("2. View All Employees");
                        System.out.println("3. Update Employee Details");
                        System.out.println("4. Delete Employee");
                        System.out.println("5. View Employee by ID");
                        System.out.println("6. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        int empOption = sc.nextInt();
                        sc.nextLine();

                        switch (empOption) {
                            case 1:
                                System.out.print("Enter Employee Name : ");
                                String emp_name = sc.nextLine();
                                System.out.print("Enter Employee Type (FULLTIME / PARTTIME ): ");
                                String emptype = sc.nextLine().toUpperCase();
                                EmployeeType emp_type = EmployeeType.valueOf(emptype);
                                Employee add_employee = new Employee(emp_name, emp_type);
                                employeeDAO.emp_add(add_employee);

                                break;
                            case 2:
                                employeeDAO.view_all_emp();
                                break;
                            case 3:
                                System.out.print("Enter Employee ID : ");
                                int emp_id = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Enter Employee Name : ");
                                String update_emp_name = sc.nextLine();
                                System.out.print("Enter Employee Type (FULLTIME / PARTTIME ) : ");
                                String updateemptype = sc.nextLine().toUpperCase();
                                EmployeeType update_emp_type = EmployeeType.valueOf(updateemptype);
                                Employee update_employee = new Employee(emp_id, update_emp_name, update_emp_type);
                                employeeDAO.emp_update(update_employee);
                                break;
                            case 4:
                                System.out.print("Enter Employee ID : ");
                                int delete_emp_id = sc.nextInt();
                                employeeDAO.emp_delete(delete_emp_id);
                                break;
                            case 5:
                                System.out.print("Enter Employee ID : ");
                                int view_emp_id = sc.nextInt();
                                Employee employee_details = employeeDAO.emp_details(view_emp_id);
                                System.out.println(employee_details);
                                break;
                            case 6:
                                innerflag = false;
                                break;

                            default:
                                System.out.println("Invalid option");
                                break;
                        }
                    }

                    break;
                case 2:
                    System.out.println("Working progress");
                    break;
                case 3:
                    flag = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }
    }
}
