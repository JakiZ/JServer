package com.jaki.jserver.mvc;

public class UserService {
    private UserDao dao = new UserDao();

    public UserBean getUser(int id){
        return dao.getUser(id);
    }
}
