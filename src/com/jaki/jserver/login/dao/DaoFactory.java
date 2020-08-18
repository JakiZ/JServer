package com.jaki.jserver.login.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {

    private static InputStream in = null;
    private static Properties properties = null;
    static {
        try {
            in = DaoFactory.class.getClassLoader().getResourceAsStream("com/jaki/jserver/login/user.properties");
            properties = new Properties();
            properties.load(in);
        } catch (IOException e) {
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

    public static UserDao getUserDao() {
        try {
            Class<?> userDaoClass = Class.forName(properties.getProperty("userDaoClass"));
            UserDao instance = (UserDao) userDaoClass.newInstance();
            return instance;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
