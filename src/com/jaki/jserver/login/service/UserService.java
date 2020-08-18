package com.jaki.jserver.login.service;

import com.jaki.jserver.login.bean.UserBean;
import com.jaki.jserver.login.dao.DaoFactory;
import com.jaki.jserver.login.dao.UserDao;
import com.jaki.jserver.login.dao.UserDaoImpl;
import com.jaki.jserver.login.exception.UserException;

public class UserService {

    private UserDao userDao = DaoFactory.getUserDao();

    public UserBean findUserByUsername(String username) throws UserException {
        UserBean user = userDao.findUserByUsername(username);
        if (user == null){
            throw new UserException(UserException.MESSAGE_NO_USER);
        }
        return user;
    }

    public void saveUser(UserBean bean) {
        userDao.saveUser(bean);
    }

}
