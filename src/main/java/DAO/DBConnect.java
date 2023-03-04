package DAO;

import java.sql.*;

public class DBConnect {
    private Connection connect;
    public DBConnect() throws Exception {
        String url = "jdbc:mysql://localhost:3306/cafedev";
        String user = "root";
        String password = "";
        connect = DriverManager.getConnection(url,user,password);
        System.out.println("connect successful.....");
    }
    public Connection getConnect() {
        return connect;
    }
}
