package com.jaki.jserver.p08.jdbc;

public class Config {

//    public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    public static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/jdbcs?userSSL=true&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT&rewriteBatchedStatements=true";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
}
