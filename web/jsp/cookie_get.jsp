<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/12/26
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%

//    Cookie cookie = new Cookie("cookie_name","cookie_value");
//    cookie.setMaxAge(60 * 60 * 1000);
//    cookie.setDomain("localhost");
//    cookie.setPath("/");
//    response.addCookie(cookie);
//
//    Cookie cookie2 = new Cookie("cookie_name","cookie_value2");
//    cookie2.setMaxAge(60 * 60 * 1000);
//    cookie.setDomain("localhost");
//    cookie.setPath("/");
//    response.addCookie(cookie2);
//
//    response.addHeader("Set-Cookie","cookie_name3=cookie_value3");
%>

    <%


        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                System.out.println(c.getName() + "<===>" + c.getValue());
            }
        }
    %>

</body>
</html>
