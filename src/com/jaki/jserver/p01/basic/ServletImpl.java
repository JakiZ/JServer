package com.jaki.jserver.p01.basic;

import javax.servlet.*;
import java.io.IOException;


/**
 * 单例，线程不安全
 */
public class ServletImpl implements Servlet {
    private static final String TAG = ServletImpl.class.getSimpleName();
    private ServletConfig config;

    /**
     * 生命周期方法：初始化，只会执行一次
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        String servletName = config.getServletName();
        String configValue = config.getInitParameter("config_name");
        System.out.println(TAG + " init " + servletName  + "," + configValue);

        this.config = config;
    }

    /**
     * 获取Servlet配置信息
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        System.out.println(TAG + " getServletConfig");
        return config;
    }

    /**
     * 生命周期方法：服务方法，会执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println(TAG + " service");


    }


    /**
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        System.out.println(TAG + " getServletInfo");
        return null;
    }


    /**
     * 生命周期方法：销毁，只会在Servlet销毁前立即执行一次
     *
     */
    @Override
    public void destroy() {
        System.out.println(TAG + " destroy");
    }
}
