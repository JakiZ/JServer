package com.jaki.jserver.login.test;

import com.jaki.jserver.login.bean.UserBean;
import com.jaki.jserver.login.util.XMLUtil;
import org.junit.Test;

import java.util.List;

public class XMLUtilTest {
    private static final String XML_PATH = "D:\\J2ee\\ideaRepository\\JServer\\web\\login\\user.xml";

    @Test
    public void testReadUsers() {
        List<UserBean> beans = XMLUtil.readUsers(XML_PATH);
        System.out.println(beans);
    }

    @Test
    public void testSaveUser(){
        UserBean userBean = new UserBean();
        userBean.setUsername("u");
        userBean.setPassword("p");
        userBean.setGender(1);
        userBean.setHobbies(new String[]{"1","2"});
        XMLUtil.saveUser(userBean,XML_PATH);
    }
}
