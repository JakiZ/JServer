package com.jaki.jserver.test;

import com.jaki.jserver.util.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;

public class JDBCUtilTest {

    @Test
    public void testGetConnection(){
        Connection connection = JDBCUtil.getConnection();
        Connection connection2 = JDBCUtil.getConnection();
        System.out.println(connection);
        System.out.println(connection2);
    }
}
