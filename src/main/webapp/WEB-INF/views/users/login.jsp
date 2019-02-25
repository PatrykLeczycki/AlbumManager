<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 24.02.19
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>

<p style="color: red">${wrongData}</p>

<table border="1" style="text-align: center" cellpadding = "10">

    <tbody>
    <form:form method="post" action="/user/login" modelAttribute="user">
        <table cellpadding = "10">

            <tr>
                <td>Login</td>
                <td>
                    <form:input path="login"/>
                </td>
                <td><form:errors path="login" cssClass="error" element="div"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><form:password path="password"/></td>
                <td><form:errors path="password" cssClass="error" element="div"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="add"></td>
            </tr>
        </table>
    </form:form>
    </tbody>
</table>
</body>
</html>
