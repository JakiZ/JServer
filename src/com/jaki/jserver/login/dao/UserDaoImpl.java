package com.jaki.jserver.login.dao;

import com.jaki.jserver.login.bean.UserBean;
import com.jaki.jserver.login.constant.Constant;
import com.jaki.jserver.login.util.CommonUtil;
import com.jaki.jserver.login.util.XMLUtil;

import java.util.List;

public class UserDaoImpl implements UserDao {

    public UserBean findUserByUsername(String username) {
        List<UserBean> userBeans = XMLUtil.readUsers(Constant.XML_USER_DAO_PATH);
        if (userBeans == null) {
            return null;
        }
        if (CommonUtil.isStringEmpty(username)) {
            return null;
        }
        for (int i = 0; i < userBeans.size(); i++) {
            UserBean userBean = userBeans.get(i);
            if (username.equals(userBean.getUsername())) {
                return userBean;
            }
        }
        return null;
    }

    public void saveUser(UserBean bean) {
        XMLUtil.saveUser(bean,Constant.XML_USER_DAO_PATH);
    }
}
