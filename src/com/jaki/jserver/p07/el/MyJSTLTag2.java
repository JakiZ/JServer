package com.jaki.jserver.p07.el;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MyJSTLTag2 extends SimpleTagSupport{


    /**
     * 执行标签的逻辑，最后由服务器执行
     * @throws JspException
     * @throws IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().write("my jstl tag 2222222");
    }


}
