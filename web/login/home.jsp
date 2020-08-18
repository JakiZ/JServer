<%@ page import="com.jaki.jserver.login.constant.Constant" %>
<%@ page import="com.jaki.jserver.login.util.CommonUtil" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/12/30
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
   <%
       String username = (String)session.getAttribute(Constant.KEY_USERNAME);
       String password = (String)session.getAttribute(Constant.KEY_PASSWORD);

       if (CommonUtil.isStringEmpty(username) || CommonUtil.isStringEmpty(password)){
           //自动重定向到登录页login.jsp
          response.sendRedirect("/login/login.jsp");
       }
   %>

    <p>
        欢迎${sessionScope.username}回来

    </p>
</body>
</html>
