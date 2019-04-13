<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
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
        <c:if test="${ownRole}">
            <div class="container" id="register-container">
                <div class="modal-content" id="register-content">
                    <div class="modal-header" style="padding: 0;">
                        <p class="modal-body" style="text-align: center; background-color: white; ">${ownRole}<span class="error"></span></p>
                    </div>
                </div>
            </div>
            <br>
        </c:if>
        <div class="container">
            <div class="row" style="background-color: #dbe4f0">
                <div>

                    <table class="table table-bordered table-hovered" border="1" style="background-color: white">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Username</th>
                            <th>E-mail</th>
                            <th>Admin role</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${users}" var="user">
                            <%@include file="../users/displaySingle.jsp"%>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </div>
    <%@include file="../sections/footer.jsp"%>
</div>


<%@include file="../utils/sort.jsp"%>

</body>
</html>
