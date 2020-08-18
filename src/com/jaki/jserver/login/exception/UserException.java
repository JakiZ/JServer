package com.jaki.jserver.login.exception;

public class UserException extends Exception {

    public static final String MESSAGE_NO_USER = "没有该用户，请您先注册！";
    public static final String MESSAGE_ERROR_USER = "用户或密码错误，请稍后再试！";
    public static final String MESSAGE_ALREADY_REGISTER = "用户已经注册，请更换用户名！";
    public static final String MESSAGE_REGISTER_OK = "注册成功！";

    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }


}
