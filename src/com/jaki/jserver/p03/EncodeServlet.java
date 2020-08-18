package com.jaki.jserver.p03;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("================响应==================");
        //        设置HttpServletResponse 输出流的字符编码 和 响应头字符编码 为：utf-8
//        resp.setHeader("Content-Type","text/html;charset=utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        设置HttpServletResponse输出流的字符编码为：utf-8
//        resp.setCharacterEncoding("utf-8");


        System.out.println("================请求==================");
        String v = req.getParameter("k");
        String contentType = req.getParameter("Content-Type");
        System.out.println(v + ","+contentType);
    }
}
