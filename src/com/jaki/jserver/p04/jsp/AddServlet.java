package com.jaki.jserver.p04.jsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

//        float p1 = getAddParam(req, "p1");
//        float p2 = getAddParam(req, "p2");
//
//        float result = p1 + p2;
//        req.setAttribute("result",result);
        req.getRequestDispatcher("jsp/add_result.jsp").forward(req,resp);

    }

    public float getAddParam(HttpServletRequest req,String key){
        String value = req.getParameter(key);
        return Float.parseFloat(value);
    }
}
