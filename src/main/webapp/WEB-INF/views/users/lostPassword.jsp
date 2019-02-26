<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 26.02.19
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lost password</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<c:if test="${not empty errorInfo}">${errorInfo}</c:if><br><br>

<form action="/user/lostpassword" method="post">

<table style="text-align: center" cellpadding = "10">
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
</body>
</html>
