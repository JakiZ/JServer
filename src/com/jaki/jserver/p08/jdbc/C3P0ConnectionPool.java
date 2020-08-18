package com.jaki.jserver.p08.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0配置文件
 * c3p0-config.xml 必须放在src下
 */
public class C3P0ConnectionPool {

    /**
     * 代码配置
     */
    @Test
    public void test(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(Config.DRIVER_CLASS_NAME);
            dataSource.setJdbcUrl(Config.URL);
            dataSource.setUser(Config.USERNAME);
            dataSource.setPassword(Config.PASSWORD);

            //设置连接池参数
            dataSource.setMaxIdleTime(1000);

            Connection connection = dataSource.getConnection();
            System.out.println(connection);

            connection.close();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 默认xml配置
     */
    @Test
    public void testXML(){
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 命名xml配置
     */
    @Test
    public void testXMLNamed(){
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource("named-config.xml");
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
