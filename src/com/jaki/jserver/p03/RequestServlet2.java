package com.jaki.jserver.p03;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

public class RequestServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("==============请求转发： 可以设置响应头和响应体================");
//        resp.setHeader("RequestServlet2","RequestServlet2_value");
//        resp.getWriter().write("RequestServlet2 Response Body");

        System.out.println("==============请求包含： 可以设置响应头和响应体================");
        resp.setHeader("RequestServlet2","RequestServlet2_value");
        resp.getWriter().write(" RequestServlet2 Response Body");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
