<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/1/13
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<form method="post" action="/UploadServlet" enctype="multipart/form-data">
    <input type="text" name="filenames" value="files"><br>
    选择文件： <input type="file" name="files"><br>
    <input type="submit"  value="上传">
</form>

</body>
</html>
