<%@ page import="com.jaki.jserver.login.constant.Constant" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/12/30
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>登录</title>

    <style type="text/css">
        p{
            color:red;
            font-size: 25px;
        }

    </style>
</head>
<body>

    <c:if test="${(sessionScope.register_status)}">
        <p>${sessionScope.register_message}</p>
    </c:if>

    <%
        Object loginStatus = session.getAttribute(Constant.KEY_LOGIN_STATUS);
        if (loginStatus == null){
            session.setAttribute(Constant.KEY_LOGIN_STATUS,true);
        }
    %>

    <c:if test="${!(sessionScope.login_status)}">
        <p>${sessionScope.login_message}</p>
    </c:if>

    <form action="/LoginServlet" method="post">
        用户：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        <input type="submit" value="登录">
    </form>

    <a href="/login/register.jsp">点击注册</a>

</body>
</html>
