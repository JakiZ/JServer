package com.jaki.jserver.p09.up_down;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream in = request.getInputStream();


        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            //单个文件大小限制
            fileUpload.setFileSizeMax(100 * 1024 * 1024);
            //表单大小
            fileUpload.setSizeMax(100 * 1024 * 1024);
            //缓存大小
            factory.setSizeThreshold(10 * 1024);
            //缓存路径
            factory.setRepository(new File("D:\\"));
            List<FileItem> fileItems = fileUpload.parseRequest(request);

            System.out.println("parse ok " + fileItems.size());
            for (int i = 0; i < fileItems.size(); i++) {
                FileItem item = fileItems.get(i);
                String name = item.getName();
                String contentType = item.getContentType();
                String fieldName = item.getFieldName();
                String value = item.getString("utf-8");
                long size = item.getSize();


                if (item.isFormField()) {
                    System.out.println(name + ":" + fieldName + ":" + contentType + ":" + value + ":" + size);
                } else {
                    System.out.println(name + ":" + fieldName + ":" + contentType + ":" + size);
                    item.write(new File("D:\\" + name));
                }
            }

//            {"code":200,"message":"ok","data":{"msg":"upload ok !"}}
//            {"code":200,"message":"ok","data":null}
//            {"code":200,"message":"ok"}


            String result = "{\"code\":200,\"msg\":\"ok\",\"data\":null}";
            System.out.println(result);
            response.getWriter().write(result);
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
