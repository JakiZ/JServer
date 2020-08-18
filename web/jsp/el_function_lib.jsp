<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/12/27
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--自定义el标签库--%>
<%@taglib prefix="mfn" uri="http://www.jaki.com/el/myelfuntion" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String[] arr = {"1","2","3"};
%>

${fn:toUpperCase("abc")}
${fn:endsWith("aabc","c" )}
${fn:join(arr,"-" )}
${fn:substringAfter("hello-world","-" )}


<p>==================自定义标签库=====================</p>
${mfn:fun()}

</body>
</html>
