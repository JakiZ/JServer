package com.jaki.jserver.login.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static Properties properties = null;
    private static InputStream in = null;

    static {
        try {
            in = JDBCUtil.class.getClassLoader().getResourceAsStream("com/jaki/jserver/login/jdbc.properties");
            properties = new Properties();
            properties.load(in);

            Class.forName(properties.getProperty("driverClassName"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
