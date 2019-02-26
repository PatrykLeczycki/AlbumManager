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

<table border="1" style="text-align: center; margin: 0 auto;" cellpadding = "10">

    <thead>
    <tr>
        <th colspan="8">Album list</th>
    </tr>
    <tr>
        <th>ID</th>
        <th>Artists</th>
        <th>Title</th>
        <th>Label</th>
        <th>Release date</th>
        <th>Format</th>
        <th colspan = "2">Actions</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${albums}" var="album">
        <%@include file="displaySingle.jsp"%>
    </c:forEach>
    </tbody>
</table>

<br><br><a href="/albums/add" class="button">Add album</a>

</body>
</html>
