package com.jaki.jserver.login.servlet;

import com.jaki.jserver.login.bean.UserBean;
import com.jaki.jserver.login.constant.Constant;
import com.jaki.jserver.login.exception.UserException;
import com.jaki.jserver.login.service.UserService;
import com.jaki.jserver.login.util.CommonUtil;
import com.jaki.jserver.login.util.XMLUtil;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(Constant.CONTENT_TYPE);
        req.setCharacterEncoding("UTF-8");

        Map<String, String[]> parameterMap = req.getParameterMap();
        UserBean userBean = CommonUtil.toBean(parameterMap, UserBean.class);

        try {
            UserBean userFromDao = userService.findUserByUsername(userBean.getUsername());
            if (userBean.getUsername().equals(userFromDao.getUsername())){
                //提示已注册，没有注册成功，并在register.jsp页面提示已经注册
                req.getSession().setAttribute(Constant.KEY_REGISTER_STATUS,false);
                req.getSession().setAttribute(Constant.KEY_REGISTER_MESSAGE,UserException.MESSAGE_ALREADY_REGISTER);
                req.getRequestDispatcher("/login/register.jsp").forward(req,resp);
            }else {
                //未注册，执行存储逻辑，并重定向登录页面login.jsp进行登录逻辑
                userService.saveUser(userBean);
                req.getSession().setAttribute(Constant.KEY_REGISTER_STATUS,true);
                req.getSession().setAttribute(Constant.KEY_REGISTER_MESSAGE,UserException.MESSAGE_REGISTER_OK);
                resp.sendRedirect("/login/login.jsp");
            }
        } catch (UserException e) {
          //未注册，执行存储逻辑，并跳转登录页面login.jsp进行登录逻辑
            XMLUtil.saveUser(userBean,Constant.XML_USER_DAO_PATH);
            req.getSession().setAttribute(Constant.KEY_REGISTER_STATUS,true);
            req.getSession().setAttribute(Constant.KEY_REGISTER_MESSAGE,UserException.MESSAGE_REGISTER_OK);
            resp.sendRedirect("/login/login.jsp");
        }
    }
}
