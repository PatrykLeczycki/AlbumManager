<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Labels</title>
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
                    <c:if test="${sessionScope.admin}">
                        <th>ID</th>
                    </c:if>
                    <th>Name</th>
                    <th>Country</th>
                    <c:if test="${sessionScope.admin}">
                        <th>Edit</th>
                        <th>Delete</th>
                    </c:if>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${labels}" var="label">
                    <%@include file="displaySingle.jsp"%>
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