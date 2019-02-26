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
    <title>Title</title>
</head>
<body>

<c:if test="${not empty newPassInfo}">${newPassInfo}</c:if><br><br>

<form action="/user/newpassword" method="post">
    <input name="oldPassword" type="password"/><br/>
    <input name="newPassword" type="password"/><br/>
    <input name="newPasswordRepeat" type="password"/><br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
