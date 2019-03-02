<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lost password</title>
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

<form action="/user/lostpassword" method="post">

    <table border="1" style="text-align: center; border-width: medium; margin: 0 auto" cellpadding = "10">
        <tr>
            <td>Login</td>
            <td><input name="login" type="text"/></td>
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
            <td></td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>

<%@include file="../modals/login.jsp"%>
<%@include file="../modals/register.jsp"%>
<%@include file="../footer.jsp"%>

</body>
</html>
