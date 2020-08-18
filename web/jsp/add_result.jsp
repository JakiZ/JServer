<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/12/26
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%

        float p1 = getAddParam(request, "p1");
        float p2 = getAddParam(request, "p2");

        float result = p1 + p2;
        request.setAttribute("result",result);
    %>

    <%!
        public float getAddParam(HttpServletRequest req,String key){
            String value = req.getParameter(key);
            return Float.parseFloat(value);
        }
    %>

    <%--<%--%>
        <%--String result = request.getAttribute("result") + "";--%>
        <%--System.out.println(result);--%>
    <%--%>--%>

    <p>
        结果是：<%= result %>

    </p>
</body>
</html>
