<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/12/30
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="mjstl" uri="http://www.jaki.com/jstl/mjstl" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    request.setAttribute("key","value");
%>
    <c:set var="key" value="set_value" scope="page"/>
    <p><c:out value="a" escapeXml="false" default="d"/></p>
    <p><c:out value="${key}"/></p>
    <c:remove var="key" scope="page"/>

    <p>
        <c:url value="/MyServlet">
            <c:param name="p1" value="1"></c:param>
            <c:param name="p2" value="2"></c:param>
        </c:url>
    </p>

<c:set var="score" value="10" scope="page"/>
<c:if test="${score > 90}">
    <c:out value="优秀"/>
</c:if>
<c:choose>
    <c:when test="${score > 80}">良好</c:when>
    <c:when test="${score > 70}">合格</c:when>
    <c:otherwise>不合格</c:otherwise>
</c:choose>

<c:forEach var="i" begin="1" end="10" step="1">
    ${i}
</c:forEach>

<p>================================</p>

<%
    String[] items = {"aa","bb","cc"};
    request.setAttribute("items",items);
%>
<c:forEach items="${items}" var="item" varStatus="vs">
    ${item}
    <c:if test="${vs.last}">最后一个元素</c:if>
</c:forEach>

<p>================================</p>
<%
    request.setAttribute("time",new Date());
    request.setAttribute("number",1.50115556);
%>
<fmt:formatDate value="${time}" pattern="yyyy-MM-DD HH:mm:ss SSS"/>
<fmt:formatNumber value="${number}" pattern="0.00"/>
<fmt:formatNumber value="${number}" pattern="#.##"/>

<p>================================</p>
<mjstl:mjstl/>
<mjstl:mjstl2/>
<mjstl:mjstl3>tag3</mjstl:mjstl3>
<mjstl:mjstl3>${requestScope.number}</mjstl:mjstl3>
<mjstl:mjstl4 ifTest="${empty requestScope.number}">my tag4</mjstl:mjstl4>
</body>
</html>
