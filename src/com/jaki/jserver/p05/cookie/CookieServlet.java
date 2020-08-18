package com.jaki.jserver.p05.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("cookie_name","cookie_value");
        resp.addCookie(cookie);

        Cookie cookie2 = new Cookie("cookie_name","cookie_value2");
        resp.addCookie(cookie2);

        resp.addHeader("Set-Cookie","cookie_name3=cookie_value3");
    }
}
