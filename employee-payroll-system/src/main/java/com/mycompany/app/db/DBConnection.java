package com.mycompany.app.db;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection{
    public static Connection getConnection(){
        String DB_URI="jdbc:mysql://localhost:3306/empy_payrol_sys";
        String DB_USER="root";
        String DB_PASSWORD="";
        try {
            return DriverManager.getConnection(DB_URI, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            System.out.println("Connection fail");
            e.printStackTrace();
            return null;
        }
    }
}