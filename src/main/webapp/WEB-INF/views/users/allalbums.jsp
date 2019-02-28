<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 28.02.19
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" style="text-align: center" cellpadding = "10">
    <thead>
    <tr>
        <th colspan="5">Label list</th>
    </tr>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Country</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${albums}" var="album">
        <%@include file="displaySingleAlbum.jsp"%>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
