<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 26.02.19
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="/css/styles.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Bootstrap Flat Modal Login Modal Form</title>
</head>
<body>
<c:if test="${not empty newPassInfo}">${newPassInfo}</c:if>
<c:if test="${not empty hello}">${hello}</c:if>

<%--TODO: usunąć z dashboarda guzik dashboard--%>

<%@include file="../headerLogged.jsp"%>

</body>
</html>
