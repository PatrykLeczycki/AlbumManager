<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 23.02.19
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Label list</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>

<h1>Label list</h1>

<table border="1" style="text-align: center" cellpadding = "10">
    <thead>
    <th>ID</th>
    <th>Name</th>
    <th>Country</th>
    <th colspan = "2">Actions</th>
    </thead>

    <tbody>
    <c:forEach items="${labels}" var="label">
        <%@include file="displaySingle.jsp"%>
    </c:forEach>
    </tbody>
</table>

<br><a href="/labels/add" class="button">Add label</a>

</body>
</html>