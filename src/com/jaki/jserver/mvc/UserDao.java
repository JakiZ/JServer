package com.jaki.jserver.mvc;

public class UserDao {

    public UserBean getUser(int id){
        return new UserBean(id,"jaki");
    }
}
