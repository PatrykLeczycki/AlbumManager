<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="files.jsp"%>
</head>
<body>

<c:choose>
    <c:when test="${sessionScope.logged}">
        <%@include file="headerLogged.jsp"%>
    </c:when>
    <c:otherwise>
        <%@include file="header.jsp"%>
    </c:otherwise>
</c:choose>

<%@include file="footer.jsp"%>

</body>
</html>