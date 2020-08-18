package com.jaki.jserver.p08.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBCPConnectionPool {

    static {


    }

    @Test
    public void test(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(Config.DRIVER_CLASS_NAME);
        dataSource.setUrl(Config.URL);
        dataSource.setUsername(Config.USERNAME);
        dataSource.setPassword(Config.PASSWORD);

        //设置池参数
        dataSource.setMaxIdle(10);

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
