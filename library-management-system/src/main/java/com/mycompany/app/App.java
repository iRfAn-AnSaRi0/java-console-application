package com.mycompany.app;

import java.lang.reflect.Member;
import java.sql.Connection;

// import java.sql.Connection;

import com.mycompany.app.db.DbConnection;

import java.util.Scanner;
import com.mycompany.app.model.Books;
import com.mycompany.app.dao.BooksDAO;
import com.mycompany.app.model.Members;
import com.mycompany.app.dao.MembersDAO;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Connection con = DbConnection.getConnection();
        if (con != null) {
            System.out.println("✅ Connected to database successfully!");
        } else {
            System.out.println("❌ Failed to connect to database!");
        }
        BooksDAO booksDAO = new BooksDAO();
        MembersDAO membersDAO = new MembersDAO();
        Scanner sc = new Scanner(System.in);
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;

        while (flag1) {
            System.out.println("1. Members ");
            System.out.println("2. Books ");
            System.out.println("3. Issued Books ");
            System.out.println("4. Return Books ");
            System.out.println("5. Exit ");

            int option1 = sc.nextInt();
            sc.nextLine();

            switch (option1) {
                case 1:
                    // System.out.println(" Work is going on ");
                    flag3 = true;
                    while (flag3) {
                        System.out.println("1. Add Members ");
                        System.out.println("2. View Members ");
                        System.out.println("3. Update Members ");
                        System.out.println("4. Delete Members ");
                        System.out.println("5. Go Back ");

                        int option3 = sc.nextInt();

                        switch (option3) {
                            case 1:
                                System.out.print("Enter Member Name : ");
                                sc.nextLine();
                                String member_name = sc.nextLine();
                                System.out.print("Enter Member Email : ");
                                String member_email = sc.nextLine();
                                System.out.print("Enter Member Phone : ");
                                String member_phone = sc.nextLine();
                                Members members = new Members(member_name, member_email, member_phone, null);
                                membersDAO.add_member(members);
                                break;
                        case 2:
                        System.out.println("All members");
                        membersDAO.view_member();
                        break;
                        case 3:
                        System.out.print("Enter Member ID : ");
                        int update_member_id = sc.nextInt();
                        System.out.print("Enter New Name : ");
                        sc.nextLine();
                        String member_new_name = sc.nextLine();
                        System.out.print("Enter New Email : ");
                        String member_new_email = sc.nextLine();
                        System.out.print("Enter New Phone : ");
                        String member_new_phone = sc.nextLine();
                        Members update_members_details = new Members(update_member_id, member_new_name, member_new_email, member_new_phone, null);
                        membersDAO.update_member(update_members_details);
                        break;
                        case 4:
                          System.out.print("Enter Member ID : ");
                          int delete_member_id = sc.nextInt();
                          membersDAO.delete_member(delete_member_id);
                        break;
                        case 5:
                        flag3 = false;
                        break;
                            default:
                            System.out.println("Invalid option");
                                break;
                        }
                    }

                    break;
                case 2:
                    flag2 = true;
                    while (flag2) {
                        System.out.println("1. Add Books ");
                        System.out.println("2. Delet Books ");
                        System.out.println("3. View All Books ");
                        System.out.println("4. Go Back ");

                        int option2 = sc.nextInt();

                        switch (option2) {
                            case 1:
                                System.out.print("Enter Book Name : ");
                                sc.nextLine();
                                String book_name = sc.nextLine();
                                System.out.print("Enter Author Name : ");
                                String book_author = sc.nextLine();
                                System.out.print("Enter Available Copies : ");
                                int available_copies = sc.nextInt();
                                Books books = new Books(book_name, book_author, available_copies);
                                booksDAO.add_book(books);
                                break;
                            case 2:
                                System.out.print("Enter Book Id : ");
                                int book_id = sc.nextInt();
                                booksDAO.delete_book(book_id);
                                System.out.println("Book remove from your library");
                            case 3:
                                System.out.println("All books of your library");
                                booksDAO.view_book();
                                break;
                            case 4:
                                flag2 = false;
                                break;
                            default:
                                System.out.println("Invalid options");
                                break;
                        }
                    }
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    flag1 = false;
                    break;
                default:
                    System.out.println("Invalid options");
                    break;
            }
        }

    }
}
