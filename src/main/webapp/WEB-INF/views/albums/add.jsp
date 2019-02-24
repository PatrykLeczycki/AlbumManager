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
    <title>Add album</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>

<h1>Add new album</h1>

<form:form method="post" action="/albums/add" modelAttribute="album">
    <%@include file="albumAddForm.jsp"%>
</form:form>

</body>
</html>