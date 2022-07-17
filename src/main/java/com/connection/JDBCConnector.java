package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {
    private static final String JDBC_URL= "jdbc:mysql://localhost:3306/data";
   private String driver = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_USER = "root";
    private static final String PASSWORD = "200357707";
    private Connection connection;


    public Connection getConnection() throws SQLException, ClassNotFoundException {
      Class.forName(driver);
        if(connection == null) {
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, PASSWORD);
        } else
            return connection;
    }
}
