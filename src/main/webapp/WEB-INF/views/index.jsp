<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 22.02.19
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<article style="background-color: white; width: 50%; display: block; transformX(300%)">
    <header>
    </header>
    <h1>Album Manager</h1>
    <p style=""><c:if test="${not empty hello}">${hello}</c:if></p>
</article>
<%--<div class="main-div">
    <a href="/albums/all">All albums</a><br>
    <a href="/albums/add">Add album</a>
</div>


<div class="main-div">
    <a href="/artists/all">All artists</a>
    <a href="/artists/add">Add artist</a>
</div>

<div class="main-div">
    <a href="/labels/all">All labels</a>
    <a href="/labels/add">Add label</a>
</div>--%>


    <table class="outter-main-table" align="center" style="position: relative; vertical-align: 50%; transform: translateY(100%)">
        <tr>
            <td>
                <%--<div class="mainpage-div">--%>
                    <table style="font-family: 'Times New Roman', Times, serif" class = "table" style="text-align: center" cellpadding = "20">
                        <thead>
                        <th style="font-size: 20px;">Albums</th>
                        </thead>
                        <tbody>
                        <tr><td><a href="/albums/all" class="button">All albums</a></td></tr>
                        <tr><td><a href="/albums/add" class="button">Add album</a></td></tr>
                        </tbody>
                    </table>
                <%--</div>--%>

                <%--<div class="mainpage-div">--%>
                    <table class = "table" style="text-align: center" cellpadding = "20">
                        <thead>
                        <th style="font-size: 20px">Artists</th>
                        </thead>
                        <tbody>
                        <tr><td><a href="/artists/all" class="button">All artists</a></td></tr>
                        <tr><td><a href="/artists/add" class="button">Add artist</a></td></tr>
                        </tbody>

                    </table>
                <%--</div>--%>

                <%--<div class="mainpage-div">--%>
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
                    <table class = "table" style="text-align: center" cellpadding = "20">
                        <thead>
                        <th style="font-size: 20px;">Dashboard</th>
                        </thead>
                        <tbody>
                        <tr><td>Test</td></tr>
                        <tr><td>Test</td></tr>
                        </tbody>

                    </table>
                <%--</div>--%>
            </td>
        </tr>
    </table>

</body>
</html>