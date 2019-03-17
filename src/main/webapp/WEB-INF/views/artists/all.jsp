<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Artists</title>
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

<%@include file="../header.jsp"%>


<div class="container">
    <div class="row" style="background-color: #dbe4f0">
        <div>
            <table class="table table-bordered table-hovered" border="1" style="background-color: white">
                <thead>
                <tr>
                    <th>Pseudonym</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Birth date</th>
                    <th>Age</th>
                    <th>Sex</th>
                    <th>Nationality</th>
                    <th>Edit</th>
                    <th>Delete</th>
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


<%--<table border="1" style="text-align: center; margin: 0 auto; border-width: medium;" cellpadding = "10">
    <thead>
    <tr>
        <th colspan="10">Artist list</th>
    </tr>
    <tr>
        <th>ID</th>
        <th>Pseudonym</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Birth date</th>
        <th>Age</th>
        <th>Sex</th>
        <th>Nationality</th>
        <th colspan = "2">Actions</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${artists}" var="artist">
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
            "order": [[2, "desc"]]
        });
    });
</script>
</body>
</html>
