<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/12/26
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String url = response.encodeURL("/SessionServlet");
    %>

    <%=
        url
    %>
</body>
</html>
