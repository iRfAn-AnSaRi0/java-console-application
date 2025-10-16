package com.mycompany.app;

import java.util.Scanner;
import com.mycompany.app.db.DbConnection;
import java.sql.Connection;
import java.util.Date;

import com.mycompany.app.model.CreateAccount;
import com.mycompany.app.model.TransactionDetails;
import com.mycompany.app.model.TransactionStatus;
import com.mycompany.app.model.TransactionType;
import com.mycompany.app.dao.CreateAccoutDAO;
import com.mycompany.app.dao.TransactionDAO;

public class App {
    public static void main(String[] args) {
        Connection con = DbConnection.getConnection();
        if (con != null) {
            System.out.println("db connected successfully");
        } else {
            System.err.println("connection failed");
        }

        Scanner sc = new Scanner(System.in);

        CreateAccoutDAO createAccoutDAO = new CreateAccoutDAO();
        TransactionDAO transactionDAO = new TransactionDAO();

        boolean flag1 = true;
        boolean flag2 = true;

        // CreateAccount create = new CreateAccount(null, null);

        // // create.generate_account_number();

        // System.out.println(create.generate_account_number());

        while (flag1) {
            System.out.println("Welcome To Our Bank");
            System.out.println("1. Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdrawal");
            System.out.println("4. Bank Transfer");
            System.out.println("5. Exit");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    flag2 = true;
                    while (flag2) {
                        System.out.println("1. Open Account");
                        System.out.println("2. Account Details");
                        System.out.println("3. Update Account Details");
                        System.out.println("4. Exit");
                        int optforAccount = sc.nextInt();
                        switch (optforAccount) {
                            case 1:
                                System.out.print("Enter Your Name : ");
                                String holderName = sc.nextLine();
                                System.out.print("Enter Your Phone : ");
                                String holderPhone = sc.nextLine();
                                CreateAccount createAccount = new CreateAccount(holderName, holderPhone);
                                createAccoutDAO.create_account(createAccount);
                                break;
                            case 2:
                                System.out.print("Enter Account Number : ");
                                long acNumber = sc.nextLong();
                                CreateAccount accountDetails = new CreateAccount(acNumber, null, null, null);
                                createAccoutDAO.view_account_info(accountDetails);
                                break;
                            case 3:
                                System.out.print("Enter Account Number : ");
                                long acNum = sc.nextLong();
                                System.out.print("Enter New Name : ");
                                sc.nextLine();
                                String newName = sc.nextLine();
                                System.out.print("Enter New Phone : ");
                                String newPhone = sc.nextLine();

                                CreateAccount updateAccountDetails = new CreateAccount(acNum, null, newName, newPhone);
                                createAccoutDAO.update_account_details(updateAccountDetails);
                                break;
                            case 4:
                                flag2 = false;
                                break;
                            default:
                                System.out.println("Invalid option");
                                break;
                        }
                    }

                    break;
                case 2:
                    System.out.print("Enter Account Number : ");
                    long ac_number_deposit = sc.nextLong();
                    System.out.print("Enter Amount : ");
                    double deposit_amount = sc.nextDouble();
                    TransactionDetails deposittransactionDetails = new TransactionDetails(ac_number_deposit,
                            deposit_amount,
                            TransactionType.DEPOSIT,
                            TransactionStatus.SUCCESS,
                            new Date(),
                            null, // no related account for deposit
                            "Deposit to account");
                    transactionDAO.deposit_withdrawal_amonut(deposittransactionDetails);
                    break;
                case 3:
                    System.out.print("Enter Account Number : ");
                    long ac_number_withdrawal = sc.nextLong();
                    System.out.print("Enter Amount : ");
                    double withdrawal_amount = sc.nextDouble();
                    TransactionDetails withdrawaltransactionDetails = new TransactionDetails(ac_number_withdrawal,
                            withdrawal_amount,
                            TransactionType.WITHDRAWAL,
                            TransactionStatus.SUCCESS,
                            new Date(),
                            null, // no related account for withdrawal
                            "Withdrawal from account");
                    transactionDAO.deposit_withdrawal_amonut(withdrawaltransactionDetails);
                    break;
                case 4:
                
                    break;
                case 5:
                    flag1 = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

    }
}
