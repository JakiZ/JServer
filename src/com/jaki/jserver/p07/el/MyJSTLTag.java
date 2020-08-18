package com.jaki.jserver.p07.el;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

public class MyJSTLTag  implements SimpleTag{

    private PageContext context;
    private JspFragment fragment;

    /**
     * 执行标签的逻辑，最后由服务器执行
     * @throws JspException
     * @throws IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        context.getOut().write("my jstl tag");
    }

    @Override
    public void setParent(JspTag parent) {

    }

    @Override
    public JspTag getParent() {
        return null;
    }

    @Override
    public void setJspContext(JspContext pc) {
        context =(PageContext) pc;
    }

    @Override
    public void setJspBody(JspFragment jspBody) {
        fragment = jspBody;
    }
}
