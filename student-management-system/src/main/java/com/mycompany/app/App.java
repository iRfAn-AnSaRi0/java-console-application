package com.mycompany.app;

import java.sql.Date;
import java.util.Scanner;
import com.mycompany.app.dao.StudentDAO;
import com.mycompany.app.model.Student;

public class App {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- CRUD MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. View Student by ID");
            System.out.println("6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name : ");
                    String name = sc.nextLine();
                    System.out.print("Enter email : ");
                    String email = sc.nextLine();
                    System.out.print("Enter phone : ");
                    String phone = sc.nextLine();
                    System.out.print("Enter dob : ");
                    String dobStr = sc.nextLine();
                    Date dob = Date.valueOf(dobStr);
                    System.out.print("Enter address : ");
                    String address = sc.nextLine();
                    Student details = new Student(name, email, phone, dob, address);
                    dao.std_details_add(details);
                    break;
                case 2:
                    dao.std_details_read_all();
                    break;
                case 3:
                    System.out.println("Enter std_id : ");
                    int std_id1 = sc.nextInt();

                    System.out.print("Enter name : ");
                    String std_name = sc.nextLine();
                    System.out.print("Enter email : ");
                    String std_email = sc.nextLine();
                    System.out.print("Enter phone : ");
                    String std_phone = sc.nextLine();
                    System.out.print("Enter dob : ");
                    String std_dobStr = sc.nextLine();
                    Date std_dob = Date.valueOf(std_dobStr);
                    System.out.print("Enter address : ");
                    String std_address = sc.nextLine();
                    Student updateDetails = new Student(std_id1, std_name, std_email, std_phone, std_dob, std_address);
                    dao.std_details_update(updateDetails);
                    break;
                case 4:
                    System.out.println("Enter std_id : ");
                    int std_id2 = sc.nextInt();
                    dao.std_details_delete(std_id2);
                    break;
                case 5:
                    System.out.println("Enter std_id : ");
                    int std_id3 = sc.nextInt();
                    Student std_details = dao.std_Details_read(std_id3);
                    System.out.println(std_details);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
