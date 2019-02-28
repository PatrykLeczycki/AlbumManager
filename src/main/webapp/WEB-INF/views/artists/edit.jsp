<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit artist</title>
    <%@include file="../files.jsp"%>
</head>
<body>

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

<%@include file="../modals.jsp"%>
<%@include file="../footer.jsp"%>

</body>
</html>
