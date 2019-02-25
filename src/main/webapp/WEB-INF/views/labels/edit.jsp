<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 23.02.19
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit label</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>

<br><a href="/" class="button">Homepage</a><br><br>

<h1>Current values:</h1>

<table border="1" style="text-align: center" cellpadding = "10">
    <thead>
    <th>ID</th>
    <th>Name</th>
    <th>Country</th>
    <th colspan = "2">Actions</th>
    </thead>

    <tbody>
    <%@include file="displaySingle.jsp"%>
    </tbody>
</table>

<h1>New values:</h1>
<form:form method="post" action="/labels/edit" modelAttribute="label">
    <form:hidden path="id"/>
    <%@include file="labelAddForm.jsp"%>
</form:form>

<br><br><a href="/labels/all" class="button">Back</a>

</body>
</html>