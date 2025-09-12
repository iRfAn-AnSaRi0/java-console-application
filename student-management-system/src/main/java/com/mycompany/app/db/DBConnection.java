package com.mycompany.app.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        String DB_URI = "jdbc:mysql://localhost:3306/std_manag_sys";
        String DB_NAME = "root";
        String DB_PASSWORD = "";
        try {
            return DriverManager.getConnection(DB_URI, DB_NAME, DB_PASSWORD);
        } catch (Exception e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return null;
        }
    }

}