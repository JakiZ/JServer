package com.jaki.jserver.p06.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("session_name","session_value");
        String sessionValue =(String) req.getSession().getAttribute("session_name");
        System.out.println("SessionServlet  sessionValue = " +sessionValue);



    }
}
