package com.jaki.jserver.login.util;

import com.jaki.jserver.login.bean.UserBean;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XMLUtil {

    private static Document getDocument(String xmlPath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            return builder.parse(xmlPath);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveUser(UserBean bean,String xmlPath) {
        Document document = getDocument(xmlPath);
        if (document == null) {
            return ;
        }

        if (bean == null){
            return;
        }

        Node users = document.getElementsByTagName("users").item(0);
        Element user = document.createElement("user");
        Element username = document.createElement("username");
        username.setTextContent(bean.getUsername() + "");
        Element password = document.createElement("password");
        password.setTextContent(bean.getPassword() + "");
        Element gender = document.createElement("gender");
        gender.setTextContent(bean.getGender() + "");
        Element hobbies = document.createElement("hobbies");
        hobbies.setTextContent(Arrays.toString(bean.getHobbies()));

        user.appendChild(username);
        user.appendChild(password);
        user.appendChild(gender);
        user.appendChild(hobbies);

        users.appendChild(user);

        TransformerFactory factory2 = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = factory2.newTransformer();
            transformer.transform(new DOMSource(document), new StreamResult(xmlPath));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public static List<UserBean> readUsers(String xmlPath) {
        List<UserBean> list = null;
        Document document = getDocument(xmlPath);
        if (document == null) {
            return null;
        }
        NodeList usernames = document.getElementsByTagName("username");
        NodeList passwords = document.getElementsByTagName("password");
        NodeList genders = document.getElementsByTagName("gender");
        NodeList hobbiess = document.getElementsByTagName("hobbies");

        if (usernames == null || usernames.getLength() == 0) {
            return list;
        }

        list = new ArrayList<>();
        for (int i = 0; i < usernames.getLength(); i++) {
            UserBean bean = new UserBean();
            bean.setUsername(usernames.item(i).getTextContent());
            bean.setPassword(passwords.item(i).getTextContent());
            bean.setGender(Integer.parseInt(genders.item(i).getTextContent()));
            String[] split = hobbiess.item(i).getTextContent().split(",");
            bean.setHobbies(split);
            list.add(bean);
        }

        return list;
    }
}
