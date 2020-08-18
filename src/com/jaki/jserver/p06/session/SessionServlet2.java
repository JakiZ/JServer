package com.jaki.jserver.p06.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sessionValue =(String) req.getSession().getAttribute("session_name");
        System.out.println("SessionServlet2  sessionValue = " +sessionValue);
    }
}
