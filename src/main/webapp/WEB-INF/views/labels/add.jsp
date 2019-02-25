<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 23.02.19
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add label</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>

<br><a href="/" class="button">Homepage</a><br><br>

<h1>Add new label</h1>

<form:form method="post" action="/labels/add" modelAttribute="label">
    <%@include file="labelAddForm.jsp"%>
</form:form>

<br><a href="/artists/all" class="button">Back</a><br><br>

</body>
</html>