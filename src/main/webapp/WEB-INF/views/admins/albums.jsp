<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Your albums</title>
    <%@include file="../files.jsp"%>
</head>
<body>
<%@include file="../header.jsp"%>

<div class="container">
    <div class="row" style="background-color: #dbe4f0">
        <div>
            <table class="table table-bordered table-hovered" border="1" style="background-color: white">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Artists</th>
                    <th>Title</th>
                    <th>Label</th>
                    <th>Release date</th>
                    <th>Format</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    <th>Your collection</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${allalbums}" var="album">
                    <%@include file="displaySingleAlbum.jsp"%>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="../footer.jsp"%>

</body>
</html>
