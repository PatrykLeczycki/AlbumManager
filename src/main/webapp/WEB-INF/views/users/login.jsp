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
<table border="1" style="text-align: center" cellpadding = "10">

    <thead>
        <th>Log in</th>
    </thead>

    <tbody>
        <form method="post" action="/login">
            <tr>
                <td><input type="text" placeholder="Login"/></td>
            </tr>
            <tr>
                <td><input type="password" placeholder="Password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Log in"/></td>
            </tr>
        </form>
    </tbody>
</table>
</body>
</html>
