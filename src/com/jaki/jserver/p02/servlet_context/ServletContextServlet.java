package com.jaki.jserver.p02.servlet_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

public class ServletContextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        context.setAttribute("attr","value");
        context.setAttribute("attr2","value2");
        String attr = (String)context.getAttribute("attr");
        System.out.println(attr);
        context.removeAttribute("attr");
        System.out.println("==========================getAttributeNames=================================");
        Enumeration<String> names = context.getAttributeNames();
        while (names.hasMoreElements()){
            String attrs = names.nextElement();
            System.out.println(attrs + "<====>" + context.getAttribute(attrs) );
        }

        System.out.println("==========================getInitParameterNames=================================");

        Enumeration<String> parameterNames = context.getInitParameterNames();
        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            System.out.println(name + "<====>" + context.getInitParameter(name) );
        }


        System.out.println("==========================获取资源路径=================================");
        //获取资源的真实路径
        String filePath = "/index.html";
        String realPath = context.getRealPath(filePath);
        System.out.println(realPath);
        //获取资源的真实路径,并转换成输入流
        InputStream in = context.getResourceAsStream(filePath);
        System.out.println(in);
        in.close();

        System.out.println("==========================获取类路径下资源=================================");
        String classPathFile = "com/jaki/jserver/p02/servlet_context/class_path_file.txt";
        //相对classes
        InputStream in2 = getClass().getClassLoader().getResourceAsStream(classPathFile);

        String classPathFile2 = "class_path_file.txt";
        //相对.class文件
        in2 = getClass().getResourceAsStream(classPathFile2);
        //相对classes文件
        in2 = getClass().getResourceAsStream("/" + classPathFile);

        int len = 0;
        byte[] buf = new byte[1024];
        while ((len=in2.read(buf)) != -1){
            System.out.println(new String(buf,0,len));
        }
        in2.close();
    }
}
