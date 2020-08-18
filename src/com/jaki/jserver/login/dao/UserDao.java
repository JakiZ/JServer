package com.jaki.jserver.login.dao;

import com.jaki.jserver.login.bean.UserBean;

public interface UserDao {
    public UserBean findUserByUsername(String username);
    public void saveUser(UserBean bean) ;
}
