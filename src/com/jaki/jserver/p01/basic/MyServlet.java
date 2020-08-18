package com.jaki.jserver.p01.basic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("doget");
//
//        resp.getWriter().write("do get ok !");

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("charset=utf-8");
//        String result = "  {\n" +
//                "        \"code\": 200,\n" +
//                "        \"total\": 1,\n" +
//                "        \"data\": {\n" +
//                "                \"id\": 1,\n" +
//                "                \"title\": \"title\",\n" +
//                "                \"content\": \"content\",\n" +
//                "                \"url\": \"https://imtt.dd.qq.com/16891/apk/D23C27FC0AFB26968525700E91614710.apk?fsname=com.qq.reader_7.1.3.888_142.apk&csr=1bbd\",\n" +
//                "                \"type\": 1,\n" +
//                "                \"version\": \"1.2\",\n" +
//                "                \"sort\": 1000,\n" +
//                "                \"add_time\": 1516268642,\n" +
//                "                \"update_time\": 1516269092,\n" +
//                "                \"status\": 1\n" +
//                "                }\n" +
//                "        }";
//
////        result = "{\"code\":400,\"msg\":\"miss a param\"}";
////        int s = 1 / 0;
//        System.out.println(result);

        String userinfo = req.getParameter("userinfo");
        System.out.println(userinfo);
//        resp.getWriter().write(userinfo);
    }
}
