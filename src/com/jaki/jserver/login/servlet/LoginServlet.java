package com.jaki.jserver.login.servlet;

import com.jaki.jserver.login.bean.UserBean;
import com.jaki.jserver.login.constant.Constant;
import com.jaki.jserver.login.exception.UserException;
import com.jaki.jserver.login.service.UserService;
import com.jaki.jserver.login.util.CommonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 先进入主页，如果没登录，跳转登录页进行登录，如果没有账号，点击注册，跳转注册页，注册完成保存注册者的信息，跳转登录页，进行登录，登录成功进入主页
 */
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(Constant.CONTENT_TYPE);

        Map<String, String[]> parameterMap = req.getParameterMap();
        UserBean userBean = CommonUtil.toBean(parameterMap, UserBean.class);

        System.out.println("userBean="+userBean);

        UserBean userFromDao = null;

        try {
            userFromDao = userService.findUserByUsername(userBean.getUsername());
            System.out.println("userFromDao="+userFromDao);
            if (userBean.equals(userFromDao)){
                //重定向到主页

                req.getSession().setAttribute(Constant.KEY_USERNAME,userBean.getUsername());
                req.getSession().setAttribute(Constant.KEY_PASSWORD,userBean.getPassword());
                resp.sendRedirect("/login/home.jsp");
            }else {
                //用户不存在，在登录页login.jsp提示用户，(转发)
                req.getSession().setAttribute(Constant.KEY_LOGIN_STATUS,false);
                req.getSession().setAttribute(Constant.KEY_LOGIN_MESSAGE,UserException.MESSAGE_ERROR_USER);
                req.getRequestDispatcher("/login/login.jsp").forward(req,resp);
            }
        } catch (UserException e) {
           //用户不存在，在登录页login.jsp提示用户，(转发)
            req.getSession().setAttribute(Constant.KEY_LOGIN_STATUS,false);
            req.getSession().setAttribute(Constant.KEY_LOGIN_MESSAGE,UserException.MESSAGE_NO_USER);
            req.getRequestDispatcher("/login/login.jsp").forward(req,resp);
            System.out.println("userFromDao e ="+userFromDao);
        }
    }
}
