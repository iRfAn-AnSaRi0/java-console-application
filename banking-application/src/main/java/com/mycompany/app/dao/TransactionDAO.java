package com.mycompany.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mycompany.app.db.DbConnection;
import com.mycompany.app.model.TransactionDetails;
import com.mycompany.app.model.TransactionType;

public class TransactionDAO {
    public void deposit_withdrawal_amonut(TransactionDetails transactionDetails) {
        String sql1 = "SELECT account_balance FROM create_account WHERE account_number=?";
        String sql2 = "UPDATE create_account SET account_balance=? WHERE account_number=?";
        String sql3 = "INSERT INTO transaction_details(account_number, transaction_amount, transaction_type, transaction_status, transaction_date_time) VALUES(?,?,?,?,?)";
        Connection con = DbConnection.getConnection();
        double current_balances = 0.0;
        try (PreparedStatement ps1 = con.prepareStatement(sql1)) {
            ps1.setLong(1, transactionDetails.get_account_number());
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                current_balances = rs.getDouble("account_balance");
            } else {
                System.err.println("Account number is invalid");
            }

            if (transactionDetails.get_transaction_type() == TransactionType.DEPOSIT) {
                try (PreparedStatement ps2 = con.prepareStatement(sql2)) {
                    double new_amount = current_balances + transactionDetails.get_transaction_amount();
                    System.out.println("Transaction amount after add : " + new_amount);
                    ps2.setDouble(1, new_amount);
                    ps2.setLong(2, transactionDetails.get_account_number());
                    ps2.executeUpdate();

                    try(PreparedStatement psTransaction1 = con.prepareStatement(sql3)){
                      psTransaction1.setLong(1, transactionDetails.get_account_number());
                      psTransaction1.setDouble(2, transactionDetails.get_transaction_amount());
                      psTransaction1.setString(3, transactionDetails.get_transaction_type().name());
                      psTransaction1.setString(4, transactionDetails.get_transaction_status().name());
                      psTransaction1.setTimestamp(5, new java.sql.Timestamp(transactionDetails.get_transaction_date_time().getTime()));
                      psTransaction1.executeUpdate();
                    }
                     System.out.println("Amount deposit successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (transactionDetails.get_transaction_type() == TransactionType.WITHDRAWAL) {
                try (PreparedStatement ps3 = con.prepareStatement(sql2)) {
                    if (current_balances < transactionDetails.get_transaction_amount()) {
                        System.out.println("Insufficent balance");
                    } else {
                        double new_balance = current_balances - transactionDetails.get_transaction_amount();
                        System.out.println("Transaction amount after sub : " + new_balance);
                        ps3.setDouble(1, new_balance);
                        ps3.setLong(2, transactionDetails.get_account_number());
                        ps3.executeUpdate();

                        try(PreparedStatement psTransaction1 = con.prepareStatement(sql3)){
                      psTransaction1.setLong(1, transactionDetails.get_account_number());
                      psTransaction1.setDouble(2, transactionDetails.get_transaction_amount());
                      psTransaction1.setString(3, transactionDetails.get_transaction_type().name());
                      psTransaction1.setString(4, transactionDetails.get_transaction_status().name());
                      psTransaction1.setTimestamp(5, new java.sql.Timestamp(transactionDetails.get_transaction_date_time().getTime()));
                      psTransaction1.executeUpdate();
                    }
                    }
                    System.out.println("Amount withdrawal successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            System.err.println("Server error");
            e.printStackTrace();
        }

        System.out.println(current_balances);

    }

}
