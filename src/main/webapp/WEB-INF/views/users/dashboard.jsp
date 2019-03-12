<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>

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
        <div class="container" id="register-container">
            <div class="modal-content" id="register-content">
                <div class="modal-header" style="padding:35px 50px;">
                    <h4><i class="fas fa-hand-paper"></i></span> Welcome, ${login}</h4>
                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <%@include file="../header.jsp"%>
    </c:otherwise>
</c:choose>

<%@include file="../footer.jsp"%>


</body>
</html>
