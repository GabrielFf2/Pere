package com.project.nasaweb.config;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    private Connection connection;
    private static MySQLConnection instance;

    public MySQLConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql//root/nasa","root","root");
            if (connection != null) {
                System.out.println("Connection Successful");
            }
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static MySQLConnection getInstance() {
        if (instance == null) {
            instance = new MySQLConnection();
        }
        return instance;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            }catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}