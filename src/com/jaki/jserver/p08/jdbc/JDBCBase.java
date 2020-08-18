package com.jaki.jserver.p08.jdbc;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCBase {

    @Test
    public void test() {
        try {
            Class.forName(Config.DRIVER_CLASS_NAME);
            Connection connection = DriverManager.getConnection(Config.URL, Config.USERNAME, Config.PASSWORD);
            System.out.println(connection);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Connection getConnection() {
        try {
            Class.forName(Config.DRIVER_CLASS_NAME);
            return DriverManager.getConnection(Config.URL, Config.USERNAME, Config.PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void basicUse() {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            String sql = "insert into stu (name,age) values('jaki',18)";
//            String sql = "update stu set name='joddy',age=22 where id = 1";
//            String sql = "delete from stu where id = 1";
            int i = statement.executeUpdate(sql);
            System.out.println(i);

            String query = "select * from stu";
            resultSet = statement.executeQuery(query);
            List<Stu> list = null;
            if (resultSet != null) {
                list = new ArrayList<>();
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                String columnName = metaData.getColumnName(1);
                System.out.println("columnCount =  " + columnCount);
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");

                    Stu stu = new Stu();
                    stu.setId(id);
                    stu.setName(name);
                    stu.setAge(age);
                    list.add(stu);
                }
            }
            System.out.println(list);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void preparedStatement() {

        try {
            Connection connection = getConnection();
            String sql = "select * from stu where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 2);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                boolean next = resultSet.next();
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");

                System.out.println("id=" + id + ",name=" + name + ",age=" + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void batch() {
        try {
            Connection connection = getConnection();
            String sql = "insert into stu (name,age) values(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            for (int i = 0; i < 10; i++) {
                statement.setString(1, "name_" + i);
                statement.setInt(2, i);
                statement.addBatch();
            }
            long b = System.currentTimeMillis();
            statement.executeBatch();
            long a = System.currentTimeMillis();
            System.out.println(a - b);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void transactionUtil(Connection connection, String name, double balance) {

        try {
            String sql = "update accounts set balance = balance - ? where username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, balance);
            statement.setString(2, name);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void transaction() {
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
            transactionUtil(connection, "jaki", 100);
            transactionUtil(connection, "joddy", -100);
            connection.commit();
        } catch (SQLException e) {
            try {
                if (connection != null)
                    connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
