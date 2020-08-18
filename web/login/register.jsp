<%--

  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/12/30
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.jaki.jserver.login.constant.Constant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
</head>
<body>

    <%--<%--%>
        <%--Object registerStatus = session.getAttribute(Constant.KEY_REGISTER_STATUS);--%>
        <%--if (registerStatus == null){--%>
            <%--session.setAttribute(Constant.KEY_REGISTER_STATUS,true);--%>
        <%--}--%>
    <%--%>--%>

    <c:if test="${(sessionScope.register_status)}">
        <p>${sessionScope.register_message}</p>
    </c:if>


    <form action="/RegisterServlet" method="post">
        用户：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        性别：  <input type="radio" name="gender" checked="checked" value="1" id="id_male"> <label for="id_male">男</label>
                <input type="radio" name="gender" value="0" id="id_female"> <label for="id_female">女</label><br>
        兴趣：  <input type="checkbox" name="hobbies" value="绘画" id="id_draw"><label for="id_draw">绘画</label>
                <input type="checkbox" name="hobbies" value="体育" id="id_gym"> <label for="id_gym">体育</label>
                <input type="checkbox" name="hobbies" value="读书" id="id_read"> <label for="id_read">读书</label>  <br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
