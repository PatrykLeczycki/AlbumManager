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
   <%@include file="../files.jsp"%>
</head>
<body>

<%--TODO: usunąć z dashboarda guzik dashboard--%>

<c:choose>
    <c:when test="${sessionScope.logged}">
        <%@include file="../headerLogged.jsp"%>
    </c:when>
    <c:otherwise>
        <%@include file="../header.jsp"%>
    </c:otherwise>
</c:choose>

<%--<%@include file="../modals/login.jsp"%>
<%@include file="../modals/register.jsp"%>--%>
<%@include file="../footer.jsp"%>


</body>
</html>
