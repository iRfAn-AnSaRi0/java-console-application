package com.mycompany.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection{
    public static Connection getConnection(){
        String DB_URI = "jdbc:postgresql://localhost:5432/library_manag_sys";
        String DB_USER = "postgres";
        String DB_PASSWORD = "postgres";

        try {
            return DriverManager.getConnection(DB_URI, DB_USER, DB_PASSWORD);
            
        } catch (Exception e) {
            System.out.println("Connection fail");
            e.printStackTrace();
            return null;
        }
    }
}