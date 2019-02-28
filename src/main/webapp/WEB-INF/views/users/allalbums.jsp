<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 28.02.19
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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

<table border="1" style="text-align: center; border-width: medium; margin: 0 auto" cellpadding = "10">
    <thead>
    <tr>
        <th colspan="7">Your album list</th>
    </tr>
    <tr>
        <th>ID</th>
        <th>Artists</th>
        <th>Title</th>
        <th>Label</th>
        <th>Release date</th>
        <th>Format</th>
        <th>Action</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${allalbums}" var="album">
        <%@include file="displaySingleAlbum.jsp"%>
    </c:forEach>
    </tbody>
</table>

<%@include file="../modals.jsp"%>

<%@include file="../footer.jsp"%>

</body>
</html>
