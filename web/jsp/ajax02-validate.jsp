<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/1/15
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证用户名</title>
    <style>
        span {
            color: red;
        }
    </style>
    <script>
        function createXMLHttpRequest() {
            try {
                return new XMLHttpRequest();
            } catch (e) {
                try {
                    return new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                    try {
                        return new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) {
                        throw e;
                    }

                }
            }
        }

        function validateUsername() {
            var uName = document.getElementById("uname");
            var sp = document.getElementById("sp");
            var uname = uName.value;
            var request = createXMLHttpRequest();
            request.open("POST", "http://localhost:8080/Ajax02Servlet", true);
            request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            request.send("username="+uname );
            request.onreadystatechange = function () {
                var status = request.status;
                var readyState = request.readyState;
                if (readyState == 4 && status == 200) {
                    var responseText = request.responseText;
                    console.log(responseText);
                    if (responseText == 1) {
                        sp.style.visibility = "visible";
                    } else {
                        sp.style.visibility = "hidden";
                    }
                }
            };

        }


    </script>
</head>
<body>

<form action="" method="post">
    <input type="text" name="uname" id="uname" onblur="validateUsername()">
    <span id="sp" style="visibility: hidden;">用户名已存在</span>
</form>

</body>
</html>
