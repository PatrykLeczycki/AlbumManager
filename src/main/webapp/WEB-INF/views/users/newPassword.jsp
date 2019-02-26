<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 26.02.19
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New password</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>

<c:if test="${not empty errorInfo}">${errorInfo}</c:if><br><br>


    <table class="table" align="center" style="text-align: center; position: relative; /*vertical-align: 50%;*/ transform: translateY(75%)" cellpadding = "10" >
        <form action="/user/newpassword" method="post">
        <tr>
            <td></td>
        </tr>
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
                <a href="/user/dashboard" style="padding: auto"><button>Back</button></a>
            </td>
        </tr>
    </table>

</body>
</html>
