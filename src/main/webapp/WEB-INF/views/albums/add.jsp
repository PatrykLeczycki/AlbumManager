<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 23.02.19
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add album</title>
    <link rel="stylesheet" href="/css/styles.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <%--<script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
    </script>--%>
</head>
<body>

<br><a href="/" class="button">Homepage</a><br><br>

<h1>Add new album</h1>

<form:form method="post" action="/albums/add" modelAttribute="album">
    <%@include file="albumAddForm.jsp"%>
</form:form>

<br><br><a href="/albums/all" class="button">Back</a>

</body>
</html>