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
    <title>Artists</title>
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
        <th colspan="9">Artist list</th>
    </tr>
    <tr>
        <th>ID</th>
        <th>Pseudonym</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
        <th>Sex</th>
        <th>Nationality</th>
        <th colspan = "2">Actions</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${artists}" var="artist">
        <%@include file="displaySingle.jsp"%>
    </c:forEach>
    </tbody>
</table>

<%@include file="../modals/login.jsp"%>
<%@include file="../modals/register.jsp"%>
<%@include file="../footer.jsp"%>

</body>
</html>
