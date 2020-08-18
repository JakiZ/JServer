package com.jaki.jserver.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 需要c3p0.jar、mchange-common-java.jar；还需要在src下配置c3p0-config.xml
 */
public class JDBCUtils2 {

    private static ComboPooledDataSource source = new ComboPooledDataSource();
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    public static ComboPooledDataSource getSource(){
        return source;
    }

    public static Connection getConnection() throws SQLException {
        Connection transactionConnection = threadLocal.get();
        if (transactionConnection != null){
            return transactionConnection;
        }
        return source.getConnection();
    }

    public static void beginTransaction() throws SQLException {
        Connection transactionConnection = threadLocal.get();
        if (transactionConnection != null){
            throw new RuntimeException("不要重复开启事务 transactionConnection =" +transactionConnection);
        }
        transactionConnection = getConnection();
        transactionConnection.setAutoCommit(false);
        threadLocal.set(transactionConnection);
    }

    public static void commitTransaction() throws SQLException {
        Connection transactionConnection = threadLocal.get();
        if (transactionConnection == null){
            throw new RuntimeException("没有开启事务, transactionConnection =" +transactionConnection);
        }
        transactionConnection.commit();
        close(transactionConnection);
    }
    public static void rollbackTransaction() throws SQLException {
        Connection transactionConnection = threadLocal.get();
        if (transactionConnection == null){
            throw new RuntimeException("没有开启事务, transactionConnection =" +transactionConnection);
        }
        transactionConnection.rollback();
        close(transactionConnection);
    }


    private static void close(Connection transactionConnection) throws SQLException {
        transactionConnection.close();
        threadLocal.remove();
        transactionConnection = null;
    }

    /**
     * 释放连接，归还连接池
     * 只有在该连接是事务专用连接时，不关闭
     */
    public static void recycle(Connection  connection) throws SQLException {
        Connection transactionConnection = threadLocal.get();
        //该连接不是事务连接
        if (connection != transactionConnection){
           connection.close();
        }
        //没有开启事务
        if (transactionConnection == null){
            connection.close ();
        }
    }
}
