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
    <title>Artist list</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>

<br><a href="/" class="button">Homepage</a><br><br>

<h1>Artist list</h1>

<table border="1" style="text-align: center" cellpadding = "10">
    <thead>
    <th>ID</th>
    <th>Pseudonym</th>
    <th>Name</th>
    <th>Surname</th>
    <th>Age</th>
    <th>Sex</th>
    <th>Nationality</th>
    <th colspan = "2">Actions</th>
    </thead>

    <tbody>
    <c:forEach items="${artists}" var="artist">
        <%@include file="displaySingle.jsp"%>
    </c:forEach>
    </tbody>
</table>

<br><br><a href="/artists/add" class="button">Add artist</a>

</body>
</html>
