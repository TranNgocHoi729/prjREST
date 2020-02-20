package com.xtel.connnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfiguration {
    public static final String SID = "orcl";
    public static final String USER_NAME = "vietlot";
    public static final String PASSWORD = "hoi1999bac";
    public static final String HOST_NAME = "localhost";
    public static final String DB_NAME = "jdbcdemo";
    public static final String DB_PORT = "1521";
    public static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final int DB_MIN_CONNECTIONS = 2;
    public static final int DB_MAX_CONNECTIONS = 6;
    public static final String URL = "jdbc:oracle:thin:@" + HOST_NAME + ":" + DB_PORT + ":" + SID;

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn =  DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {       	
            e.printStackTrace();
        }
        return conn;
    }

}
