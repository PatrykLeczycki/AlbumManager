<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Albums</title>
    <%@include file="../utils/files.jsp"%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/dataTables.bootstrap.min.js"></script>
    <style>
        th{
            text-align: center;
        }
    </style>
</head>
<body>

<div id="outer-container">
    <%@include file="../sections/header/header.jsp"%>

    <div id="body">
        <div class="container">
            <div class="row" style="background-color: #dbe4f0">
                <div>
                    <table class="table table-bordered table-hovered" border="1" style="background-color: white">
                        <thead>
                        <tr>
                            <sec:authorize access="hasRole('USER') && hasRole('ADMIN')">
                                <th>ID</th>
                            </sec:authorize>
                            <th>Artists</th>
                            <th>Title</th>
                            <th>Label</th>
                            <th>Release date</th>
                            <th>Format</th>
                            <sec:authorize access="hasRole('USER') && hasRole('ADMIN')">
                                <th>Edit</th>
                                <th>Delete</th>
                                <th>Your collection</th>
                            </sec:authorize>
                            <sec:authorize access="hasRole('USER') && !hasRole('ADMIN')">
                                <th>Your collection</th>
                            </sec:authorize>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${albums}" var="album">
                            <%@include file="displaySingle.jsp"%>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../sections/footer.jsp"%>
</div>

<%@include file="../utils/sortAlbums.jsp"%>
</html>