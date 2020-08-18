package com.jaki.jserver.p03;


import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;


public class ResponseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendError(404, "资源不存在");

//        resp.setStatus(200);
//        resp.getWriter().write("request ok ");

//        resp.setHeader("header_key", "header_value");
//        resp.setHeader("header_key2", "header_value2");
//        resp.addHeader("header_key2", "header_value22");
//        resp.setIntHeader("header_int", 250);
//        resp.setDateHeader("header_long", System.currentTimeMillis());

//        重定向
//        resp.setStatus(302);
//        resp.setHeader("location","https://www.baidu.com/");
//        resp.setHeader("location","/RequestServlet");
//        resp.sendRedirect("https://www.baidu.com/");
//        resp.sendRedirect("/RequestServlet");


//        定时刷新
//        resp.setHeader("refresh","3;url=https://www.baidu.com/");
//        resp.setHeader("refresh","3;url=/RequestServlet");

//        禁用浏览器缓存
//        resp.setHeader("cache-control", "no-cache");
//        resp.setHeader("pragma", "no-cache");
//        resp.setHeader("expire", "-1");



//        字符流，不能和ServletOutputStream同时使用
//        PrintWriter printWriter = resp.getWriter();
//        字节流，不能和PrintWriter同时使用
//        ServletOutputStream servletOutputStream = resp.getOutputStream();
//        servletOutputStream.write("ServletOutputStream".getBytes());
//        String imgPath = "D:\\J2ee\\ideaRepository\\JServer\\src\\com\\jaki\\jserver\\p03\\img.png";
//
//         imgPath = getServletContext().getRealPath("/WEB-INF/classes/com/jaki/jserver/p03/img.png");
//        FileInputStream in = new FileInputStream(imgPath);
//        byte[] bytes = IOUtils.toByteArray(in);
//        servletOutputStream.write(bytes);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
