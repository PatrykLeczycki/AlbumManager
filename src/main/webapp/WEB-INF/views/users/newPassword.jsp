<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Use1/4 oglądających r: patryk
  Date: 26.02.19
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New password</title>
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

<table border="1" style="text-align: center; border-width: medium; margin: 0 auto" cellpadding = "10">
        <form action="/user/newpassword" method="post">
        <tr>
            <td>Old password</td>
            <td><input name="oldPassword" type="password"/></td>
            <td></td>
        </tr>
        <tr>
            <td>New password</td>
            <td><input name="newPassword" type="password"/><br/></td>
            <td></td>
        </tr>
        <tr>
            <td>Confirm new password</td>
            <td><input name="newPasswordRepeat" type="password"/><br/></td>
            <td></td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" value="Submit"></form>
                <a href="/user/dashboard" style="padding: auto; color: black"><button>Back</button></a>
            </td>
        </tr>
    </table>

<%@include file="../modals/login.jsp"%>
<%@include file="../modals/register.jsp"%>
<%@include file="../footer.jsp"%>

</body>
</html>
