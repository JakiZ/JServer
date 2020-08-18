package com.jaki.jserver.p07.el;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MyJSTLTag4 extends SimpleTagSupport{

    /**
     * 定义属性
     */
    private boolean ifTest;

    public void setIfTest(boolean ifTest) {
        this.ifTest = ifTest;
    }

    /**
     * 执行标签的逻辑，最后由服务器执行
     * @throws JspException
     * @throws IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if (ifTest){
            getJspBody().invoke(out);
        }else {
            out.print("nothing ");
            getJspBody().invoke(out);
        }

    }


}
