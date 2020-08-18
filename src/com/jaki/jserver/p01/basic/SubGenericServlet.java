package com.jaki.jserver.p01.basic;

import javax.servlet.*;
import java.io.IOException;

public class SubGenericServlet extends GenericServlet{

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     * 防止初始化init(ServletConfig config)覆盖了原来的ServletConfig config赋值
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }
}
