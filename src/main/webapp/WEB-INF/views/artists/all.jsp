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
        <c:if test="${deleteerror || deleteerror2 || artistnotfound}">
            <div class="container" id="register-container">
                <div class="modal-content" id="register-content">
                    <div class="modal-header" style="padding: 0;">
                        <p class="modal-body error" style="text-align: center; background-color: white; ">
                            <c:if test="${deleteerror}">
                                Error - Firstly delete albums associated with the artist
                            </c:if>
                            <c:if test="${deleteerror2}">
                                Error - Firstly delete bands associated with the artist
                            </c:if>
                            <c:if test="${artistnotfound}">
                                Error - Artist with given ID not found
                            </c:if>
                        </p>
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
