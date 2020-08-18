package com.jaki.jserver.p02.servlet_context;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CountServlet extends HttpServlet {

    private int count;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().setAttribute("count", (++count));
        System.out.println("本Servlet被访问次数为：" + getServletContext().getAttribute("count"));
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().setAttribute("count", (++count));
        System.out.println("本Servlet被访问次数为：" + getServletContext().getAttribute("count"));

        String aa = "{\"code\":200,\"data\":[{\"age\":\"12\",\"gender\":\"1\",\"name\":\"jaki\"},{\"age\":\"42\",\"gender\":\"0\",\"name\":\"lucy\"}],\"error\":0,\"total\":0}";

        resp.getWriter().write(aa);
    }
}
