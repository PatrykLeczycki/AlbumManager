<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 24.02.19
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/styles.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
    </script>
</head>
<body>
<br><a href="/" class="button">Homepage</a><br><br>

<h1>Current values:</h1>

<table border="1" style="text-align: center" cellpadding = "10" align="center" style="position: relative; vertical-align: 50%; transform: translateY(100%)">
    <thead>
    <tr>
        <th colspan="7">Edit album</th>
    </tr>
    <tr>
        <th>ID</th>
        <th>Artists</th>
        <th>Title</th>
        <th>Label</th>
        <th>Release date</th>
        <th>Format</th>
        <th colspan = "2">Actions</th>
    </tr>
    </thead>

    <tbody>
    <%@include file="displaySingle.jsp"%>
    </tbody>
</table>

<h1>New values:</h1>
<form:form method="post" action="/albums/edit" modelAttribute="album">
    <form:hidden path="id"/>
    <%@include file="albumAddForm.jsp"%>
</form:form>

<br><br><a href="/albums/all" class="button">Back</a>

</body>
</html>
