package org.example;

import java.sql.*;

public class SqlConnection {
    private Connection connection;
    public SqlConnection() {
        Connection conn = null;
        try {
            this.connection = null;
            String url = "jdbc:sqlite:C:\\Users\\nanda\\Documents\\SQL Lite\\Database\\ecommerce.db";

            this.connection = DriverManager.getConnection(url);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public Connection getConnection() {
        return connection;
    }
}