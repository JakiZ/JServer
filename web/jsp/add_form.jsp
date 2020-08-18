<%@ page import="com.jaki.jserver.util.VerifyCode" %><%--
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



    <script>
        function changeVerifyCode() {
            var img = document.getElementById("vc");
            img.src =  "/AddVCServlet?" + new Date().getTime();
        }
    </script>
</head>
<body>

<form action="/AddServlet" method="get">
    整数1： <input type="text" name="p1"> <br>
    整数2： <input type="text" name="p2"><br>
    验证码： <input type="text" name="p3"> <img src="/AddVCServlet" id="vc" onclick="changeVerifyCode();"><br>
    <input type="submit" value="相加">
</form>



</body>
</html>
