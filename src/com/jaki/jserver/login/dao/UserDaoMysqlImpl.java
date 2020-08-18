package com.jaki.jserver.login.dao;

import com.jaki.jserver.login.bean.UserBean;
import com.jaki.jserver.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoMysqlImpl implements UserDao {

    @Override
    public UserBean findUserByUsername(String username) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
             connection = JDBCUtil.getConnection();
            String sql = "select * from users where username = ?";
             statement = connection.prepareStatement(sql);
            statement.setString(1,username);
             set = statement.executeQuery();
            if (set != null && set.next()){
                UserBean bean = new UserBean();
                bean.setUsername(username);
                bean.setPassword(set.getString("password"));
                bean.setGender(set.getInt("gender"));
                bean.setHobbies(set.getString("password").split(","));
                return bean;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (set != null){
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null){
                try {
                    statement .close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public void saveUser(UserBean bean) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "insert into users (username,password,gender,hobbies) values (?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,bean.getUsername());
            statement.setString(2,bean.getPassword());
            statement.setInt(3,bean.getGender());
            String[] hobbies = bean.getHobbies();
            StringBuffer buffer = new StringBuffer();
            if (hobbies != null){
                for (int i = 0; i < hobbies.length; i++) {
                    if (i == hobbies.length - 1){
                        buffer.append(hobbies[i]);
                    }else {
                        buffer.append(hobbies[i]).append(",");
                    }
                }
            }
            statement.setString(4,buffer.toString() );
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (set != null){
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null){
                try {
                    statement .close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
