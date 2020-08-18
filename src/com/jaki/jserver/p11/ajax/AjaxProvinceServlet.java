package com.jaki.jserver.p11.ajax;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.SAXParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

public class AjaxProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        InputStream in = null;
        try {
            in = getClass().getResourceAsStream("cities.xml");

            SAXReader reader = new SAXReader();
            Document document = reader.read(in);
            Element country = document.getRootElement();
            List<Element> provinces = country.elements("province");
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < provinces.size(); i++) {
                Element element = provinces.get(i);
                String text = element.attributeValue("name");
                if (i == provinces.size() - 1) {
                    buffer.append(text);
                } else {
                    buffer.append(text).append(",");
                }
        }
            resp.getWriter().write(buffer.toString());
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            if (in != null) in.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/xml;charset=utf-8");

        PrintWriter writer = resp.getWriter();
        InputStream in = null;
        try {
            StringBuffer buffer = new StringBuffer();
            String province = req.getParameter("province");
            if (province != null && province.length() > 1) {
                in = getClass().getResourceAsStream("cities.xml");
                SAXReader reader = new SAXReader();
                Document document = reader.read(in);
                Element root = document.getRootElement();
                List<Element> provinces = root.elements("province");
                for (int i = 0; i < provinces.size(); i++) {
                    Element pro = provinces.get(i);
                    String proName = pro.attributeValue("name");
                    if (!proName.equals(province)) {
                        continue;
                    }
                    buffer.append("<province>");
                    List<Element> cities = pro.elements("city");
                    for (int j = 0; j < cities.size(); j++) {
                        Element city = cities.get(j);
                        String cityName = city.getText();
                        buffer.append("<city>").append(cityName).append("</city>");
                    }
                    buffer.append("</province>");
                }
                writer.write(buffer.toString());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            if (in != null) in.close();
        }

    }
}
