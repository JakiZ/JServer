package com.jaki.jserver.p07.el;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MyJSTLTag3 extends SimpleTagSupport{


    /**
     * 执行标签的逻辑，最后由服务器执行
     * @throws JspException
     * @throws IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.write("#####");
        getJspBody().invoke(out);
        out.write("%%%%%");
    }


}
