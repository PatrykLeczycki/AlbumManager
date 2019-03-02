<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <<%@include file="../files.jsp"%>
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

<%@include file="../modals/login.jsp"%>
<%@include file="../modals/register.jsp"%>
<%@include file="../footer.jsp"%>


</body>
</html>