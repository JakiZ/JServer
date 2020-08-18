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

public class RequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //获取请求方式
//        String scheme = req.getScheme();
//        //服务器名
//        String serverName = req.getServerName();
//        //端口号
//        int serverPort = req.getServerPort();
//        //项目名
//        String contextPath = req.getContextPath();
//        //Servlet路径
//        String servletPath = req.getServletPath();
//        //请求参数
//        String queryString = req.getQueryString();
//        //项目名+Servlet路径
//        String requestURI = req.getRequestURI();
//        //不含请求参数的url
//        String requestURL = req.getRequestURL().toString();
//        String x = "请求方式:" + scheme + ",服务器名:"
//                + serverName + ",端口号:"
//                + serverPort + ",项目名:"
//                + contextPath + ",Servlet路径:"
//                + servletPath + ",请求参数:"
//                + queryString + ",URI:"
//                + requestURI + ",URL:"
//                + requestURL;
//        System.out.println(x);
//
//        String cacheControl = req.getHeader("cache-control");
//        //访问来源
//        String referer = req.getHeader("referer");
//        System.out.println(cacheControl + "------" + referer);
//        Enumeration<String> acceptEncoding = req.getHeaders("Accept-Encoding");
//        while (acceptEncoding.hasMoreElements()) {
//            String key = acceptEncoding.nextElement();
//            System.out.println(key + "<==>" + req.getHeader(key));
//        }
//
//
//        System.out.println("=================获取请求参数===================");
//        String v = req.getParameter("k");
//        System.out.println("k = " + v);
//        Enumeration<String> names = req.getParameterNames();
//        while (names.hasMoreElements()) {
//            String name = names.nextElement();
//            System.out.println(name + "---" + req.getParameter(name));
//        }
//        String[] v2s = req.getParameterValues("k2");
//        for (String v2 : v2s) {
//            System.out.println("k2 : " + v2);
//        }
//
//        Map<String, String[]> map = req.getParameterMap();
//        Set<Map.Entry<String, String[]>> entries = map.entrySet();
//        for (Map.Entry<String, String[]> e : entries) {
//            String[] values = e.getValue();
////            StringBuffer buffer = new StringBuffer();
////            for (String v3 : values){
////                buffer.append(v3).append(",");
////            }
////            System.out.println("map: " + e.getKey() + "=>" +buffer.toString());
//            System.out.println("map: " + e.getKey() + "=>"+ Arrays.toString(values));
//        }

//        System.out.println("==============请求转发： 只能设置响应头，不能设置响应体================");
//        http://localhost:8080/RequestServlet?k=v&k2=v2&k2=v22&k3=v3
//        resp.setHeader("RequestServlet", "RequestServlet_value");
//        resp.getWriter().write("RequestServlet Response Body");
//        req.getRequestDispatcher("/RequestServlet2").forward(req, resp);



        System.out.println("==============请求包含： 可以设置响应头和响应体================");
        resp.setHeader("RequestServlet", "RequestServlet_value");
        resp.getWriter().write("RequestServlet Response Body");
        req.getRequestDispatcher("/RequestServlet2").include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
