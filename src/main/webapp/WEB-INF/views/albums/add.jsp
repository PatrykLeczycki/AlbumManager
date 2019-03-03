<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <%@include file="../files.jsp"%>
</head>
<body>

<c:choose>
    <c:when test="${sessionScope.logged}">
        <%@include file="../headerLogged.jsp"%>
    </c:when>
    <c:otherwise>
        <%@include file="../header.jsp"%>
    </c:otherwise>
</c:choose>

<div class="container" id="register-container">

    <!-- Modal content-->
    <div class="modal-content" id="register-content">
        <div class="modal-header" style="padding:35px 50px;">
            <%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
            <h4><span class="glyphicon glyphicon-cd"></span> Add album</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
            <form:form method="post" action="/albums/add" modelAttribute="album">
                <div class="form-group">
                    <label><i class="fas fa-users"></i></span> Artists</label><br>
                    <form:select path="artists">
                        <form:option value="0" label="Choose artists" disabled="true"/>
                        <form:options itemValue="id" itemLabel="pseudonym" items="${artists}"/>
                    </form:select>
                </div>
                <div class="form-group">
                    <label><span class="glyphicon glyphicon-pencil"></span></span> Title</label><br>
                    <form:input path="title"/>
                </div>
                <div class="form-group">
                    <label><i class="fas fa-signature"></i></span> Label</label><br>
                    <form:select path="label">
                        <form:option value="0" label="Choose label"/>
                        <form:options itemValue="id" itemLabel="name" items="${labels}"/>
                    </form:select>
                </div>
                <div class="form-group">
                    <label><span class="glyphicon glyphicon-calendar"></span> Release date</label><br>
                    <form:input type="date" path="releaseDate"/>
                </div>
                <div class="form-group">
                    <label><span class="glyphicon glyphicon-cd"></span></span> Format</label><br>
                    <form:select path="format" items="${formats}"/>
                </div>
                <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-cd"></span> Add album</button>
            </form:form>
        </div>
        <div class="modal-footer">
            <%--            <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>--%>
            <p><a href="/albums/all" style="padding: auto">Back to albums</a></p>
        </div>
    </div>
</div>

<form:form method="post" action="/albums/add" modelAttribute="album">
    <%@include file="albumAddForm.jsp"%>
</form:form>

<%--<%@include file="../modals/login.jsp"%>
<%@include file="../modals/register.jsp"%>--%>
<%@include file="../footer.jsp"%>
</body>
</html>