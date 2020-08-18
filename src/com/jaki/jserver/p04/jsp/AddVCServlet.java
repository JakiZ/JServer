package com.jaki.jserver.p04.jsp;

import com.jaki.jserver.util.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddVCServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String verifyCode = VerifyCode.getInstance().getVerifyCode(resp.getOutputStream());
        req.getSession().setAttribute("verify_code",verifyCode);
    }
}
