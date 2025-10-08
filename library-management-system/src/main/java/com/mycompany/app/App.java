package com.mycompany.app;

import java.sql.Connection;

import com.mycompany.app.db.DbConnection;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try (Connection conn = DbConnection.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("✅ Connected to PostgreSQL successfully!");
            } else {
                System.out.println("❌ Connection failed.");
            }
        } catch (Exception e) {
            System.out.println("❌ Connection failed with exception:");
            e.printStackTrace();
        }
    }
}
