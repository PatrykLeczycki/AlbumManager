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
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<c:if test="${not empty newPassInfo}">${newPassInfo}</c:if>
<c:if test="${not empty hello}">${hello}</c:if>


<table class="outter-main-table" align="center" style="position: relative; /*vertical-align: 50%;*/ transform: translateY(75%)">
    <tbody>
    <tr>
        <td>
            <%--<div class="mainpage-div">--%>
            <table style="font-family: 'Times New Roman', Times, serif" class = "table" style="text-align: center" cellpadding = "20">
                <thead>
                <th style="font-size: 20px;">Account</th>
                </thead>
                <tbody>
                <tr><td><a href="/user/newpassword"><button>Change password</button></a></td></tr>
                <tr><td><a href="/logout"><button>Log out</button></a></td></tr>
                </tbody>
            </table>
            <%--</div>--%>
        </td>
        <%--<div class="mainpage-div">--%>
        <td>
            <table class = "table" style="text-align: center" cellpadding = "20">
                <thead>
                <th style="font-size: 20px">Artists</th>
                </thead>
                <tbody>
                <tr><td><a href="/artists/all" class="button">All artists</a></td></tr>
                <tr><td><a href="/artists/add" class="button">Add artist</a></td></tr>
                </tbody>

            </table>
        </td>
        <%--</div>--%>

        <%--<div class="mainpage-div">--%>
        <td>
            <table class = "table" cellpadding = "20">
                <thead>
                <th style="font-size: 20px">Labels</th>
                </thead>
                <tbody>
                <tr><td><a href="/labels/all" class="button">All labels</a></td></tr>
                <tr><td><a href="/labels/add" class="button">Add label</a></td></tr>
                </tbody>

            </table>
            <%--</div>--%>

            <%--<div class="mainpage-div">--%>
            <%--</div>--%>
        </td>
    </tr>
    <% if (session.getAttribute("logged") == null) { %>
    <tr>
        <td></td>
        <td>
            <table class = "table" style="text-align: center" cellpadding = "20">
                <thead>
                <th style="font-size: 20px;">Dashboard</th>
                </thead>
                <tbody>
                <tr><td><a href="/login" class="button">Log in</a></td></tr>
                </tbody>

            </table>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>

</body>
</html>
