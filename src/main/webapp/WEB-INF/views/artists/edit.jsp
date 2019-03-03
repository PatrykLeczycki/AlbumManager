<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit artist</title>
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

<form:form method="post" action="/artists/edit" modelAttribute="artist">
    <form:hidden path="id"/>
    <%@include file="artistAddForm.jsp"%>
</form:form>

<%--<%@include file="../modals/login.jsp"%>--%>
<%--<%@include file="../modals/register.jsp"%>--%>
<%@include file="../footer.jsp"%>

</body>
</html>
