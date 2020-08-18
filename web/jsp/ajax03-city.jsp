<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/1/15
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省市联动</title>
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

        function getProvinces() {
            var province = document.getElementById("province");

            var request = createXMLHttpRequest();
            request.open("GET", "http://localhost:8080/AjaxProvinceServlet", true);
            request.send(null);
            request.onreadystatechange = function () {
                var status = request.readyState;
                var code = request.status;
                if (status == 4 && code == 200) {
                    var text = request.responseText;

                    //清除之前的option
                    var options = province.getElementsByTagName("option");
                    for (var i = 1; i < options.length; i++) {
                        province.removeChild(options[i]);
                    }

                    //添加新的省份元素
                    var splits = text.split(",");
                    for (var i = 0; i < splits.length; i++) {
                        var option = document.createElement("option");
                        option.innerText = splits[i];
                        province.appendChild(option);
                    }
                }
            }
        }

        window.onload = function (ev) {
            getProvinces();
        }

        function changeProvince() {
            var province = document.getElementById("province");
            var city = document.getElementById("city");
            var selected = province.options[province.selectedIndex].value;

            var request = createXMLHttpRequest();
            request.open("POST", "http://localhost:8080/AjaxProvinceServlet", true);
            request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            request.send("province=" + selected);
            request.onreadystatechange = function () {
                var code = request.status;
                var state = request.readyState;
                if (code == 200 && state == 4) {
                    var pro = request.responseXML;
                    var cities = pro.getElementsByTagName("city");

                    //清除市级信息
                    var options = city.getElementsByTagName("option");
                    while (options.length > 1){
                        city.removeChild(options[options.length - 1]);
                    }
                    for (var i = 0; i < cities.length; i++) {
                        var cityEle = cities.item(i);
                        var option = document.createElement("option");
                        option.innerText = cityEle.innerHTML;
                        city.appendChild(option);
                    }
                }
            }
        }

    </script>
</head>
<body>
<select id="province" onchange="changeProvince()">
    <option id="p1">选择省</option>
</select>

<select id="city">
    <option id="c1">选择市</option>
</select>
</body>
</html>
