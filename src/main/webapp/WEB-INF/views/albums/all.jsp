<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 24.02.19
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Albums</title>
    <%@include file="../files.jsp"%>
</head>
<body>

<c:choose>
    <c:when test="${sessionScope.logged}">
        <%@include file="../headerLogged.jsp"%>
    </c:when>
    <c:otherwise>
        <%@include file="../header.jsp"%>
    </c:otherwise>
</c:choose>

<table border="1" style="text-align: center; margin: 0 auto; border-width: medium;" cellpadding = "10">

    <thead>
    <tr>
        <th colspan="9">Album list</th>
    </tr>
    <tr>
        <th>ID</th>
        <th>Artists</th>
        <th>Title</th>
        <th>Label</th>
        <th>Release date</th>
        <th>Format</th>
        <th colspan = "3">Actions</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${albums}" var="album">
        <%@include file="displaySingle.jsp"%>
    </c:forEach>
    </tbody>

    <%@include file="../modals/login.jsp"%>
    <%@include file="../modals/register.jsp"%>
<%@include file="../footer.jsp"%>
</table>
</body>
</html>