package com.jaki.jserver.p09.up_down;

import com.jaki.jserver.util.CommonUtil;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = "张三.png";
        resp.setHeader("content-disposition","attachment;filename=" + CommonUtil.downloadFileName(fileName,req));
        String mimeType = getServletContext().getMimeType(fileName);
        resp.setContentType(mimeType);
        FileInputStream in = new FileInputStream("D:\\张三.png");
        IOUtils.copy(in,resp.getOutputStream());
        in.close();
    }
}
