<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Artists</title>
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
                            <th>Pseudonym</th>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Birth date</th>
                            <th>Age</th>
                            <th>Sex</th>
                            <th>Nationality</th>
                            <sec:authorize access="hasRole('USER') && hasRole('ADMIN')">
                                <th>Edit</th>
                                <th>Delete</th>
                            </sec:authorize>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${artists}" var="artist">
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


<%@include file="../utils/sortOther.jsp"%>
</body>
</html>
