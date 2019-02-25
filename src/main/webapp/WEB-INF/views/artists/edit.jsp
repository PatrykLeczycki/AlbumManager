<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Edit artist</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>

<br><a href="/" class="button">Homepage</a><br><br>

<h1>Current values:</h1>

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
    <%@include file="displaySingle.jsp"%>
    </tbody>
</table>

<h1>New values:</h1>
<form:form method="post" action="/artists/edit" modelAttribute="artist">
    <form:hidden path="id"/>
    <%@include file="artistAddForm.jsp"%>
</form:form>

<br><br><a href="/artists/all" class="button">Back</a>

</body>
</html>
