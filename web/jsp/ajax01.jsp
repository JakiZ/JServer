<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/1/15
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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

        function ajaxGet() {
            var request = createXMLHttpRequest();
            request.open("GET", "http://localhost:8080/MyServlet", true);
            request.send(null);
            request.onreadystatechange = function () {
                var state = request.readyState;//0-4
                var stateCode = request.status;
                if (state == 4 && stateCode == 200) {
                    var textResponse = request.responseText;
                    var responseXML = request.responseXML;
                    console.log(textResponse);
                }
            }
        }

        function ajaxPost() {
            var request = createXMLHttpRequest();
            request.open("POST", "http://localhost:8080/MyServlet", true);
            request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            request.send("username=张三&password=abc123");
            request.onreadystatechange = function () {
                var state = request.readyState;//0-4
                var stateCode = request.status;
                if (state == 4 && stateCode == 200) {
                    var textResponse = request.responseText;
                    var responseXML = request.responseXML;
                    console.log(textResponse);
                }
            }
        }

        window.onload = function (ev) {
            //ajaxGet();
            ajaxPost();
        }
    </script>
</head>
<body>

</body>
</html>
