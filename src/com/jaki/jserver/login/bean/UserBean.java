package com.jaki.jserver.login.bean;

import java.util.Arrays;

public class UserBean  {
    private String username;

    private String password;
    /**
     * 性别，0 女；1 男
     */
    private int gender;
    private String[] hobbies;

    public UserBean() {
    }

    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", hobbies=" + Arrays.toString(hobbies) +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UserBean)){
            return false;
        }
        if (((UserBean) obj).getUsername().equals(username)
                && ((UserBean) obj).getPassword().equals(password)){
            return true;
        }
        return false;
    }
}
