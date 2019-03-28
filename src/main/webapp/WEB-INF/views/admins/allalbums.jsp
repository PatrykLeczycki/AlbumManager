<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Albums</title>
    <%@include file="../files.jsp"%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/dataTables.bootstrap.min.js"></script>
    <style>
        th{
            text-align: center;
        }
    </style>
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
                    <th>Collection</th>
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
<c:choose>
    <c:when test="${sessionScope.admin}">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/sortNineCols.js"></script>
    </c:when>
    <c:when test="${sessionScope.user}">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/sortSevenCols.js"></script>
    </c:when>
    <c:otherwise>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/sortSixCols.js"></script>
    </c:otherwise>
</c:choose>
</body>
</html>