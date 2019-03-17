<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Labels</title>
    <%@include file="../files.jsp"%>
    <script type="text/javascript" src="/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="/js/dataTables.bootstrap.min.js"></script>
    <style>
        th{
            text-align: center;
        }
    </style>
</head>
<body>

<c:choose>
    <c:when test="${sessionScope.user}">
        <%@include file="../userHeader.jsp"%>
    </c:when>
    <c:otherwise>
        <%@include file="../unloggedHeader.jsp"%>
    </c:otherwise>
</c:choose>

<div class="container">
    <div class="row" style="background-color: #dbe4f0">
        <div>
            <table class="table table-bordered table-hovered" border="1" style="background-color: white">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Country</th>
                    <th>Edit</th>
                    <th>Delete</th>
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



<%--<table border="1" style="text-align: center; margin: 0 auto; border-width: medium;" cellpadding = "10">
    <thead>
    <tr>
        <th colspan="5">Label list</th>
    </tr>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Country</th>
        <th colspan = "2">Actions</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${labels}" var="label">
        <%@include file="displaySingle.jsp"%>
    </c:forEach>
    </tbody>
</table>--%>

<%@include file="../footer.jsp"%>

<script type="text/javascript">
    $(document).ready(function() {
        $(".table").DataTable({
            "ordering": true,
            "searching": true,
            "paging": true,
            "columnDefs": [
                {
                    "targets": [-1,-2],
                    "searchable": false,
                    "orderable": false
                }
            ],
            "order": []
        });
    });
</script>

</body>
</html>