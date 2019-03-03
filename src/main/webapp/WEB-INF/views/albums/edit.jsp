<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit album</title>
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

<%--<table border="1" style="text-align: center; margin: 0 auto; border-width: medium;" cellpadding = "10">
    <thead>
    <tr>
        <th colspan="9">Edit album</th>
    </tr>
    <tr>
        <th>ID</th>
        <th>Artists</th>
        <th>Title</th>
        <th>Label</th>
        <th>Release date</th>
        <th>Format</th>
        <th colspan = "3">Actions</th>
    </tr>
    </thead>

    <tbody>
    <%@include file="displaySingle.jsp"%>
    </tbody>
</table>--%>

<div class="container" id="register-container">

    <!-- Modal content-->
    <div class="modal-content" id="register-content">
        <div class="modal-header" style="padding:35px 50px;">
            <%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
            <h4><span class="glyphicon glyphicon-cd"></span> Edit album</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
            <form:form method="post" action="/albums/edit" modelAttribute="album">
                <form:hidden path="id"/>
                <div class="form-group">
                    <label><i class="fas fa-users"></i>Artists</label>
                    <form:errors path="artists" cssClass="error" element="div"/><br>
                    <form:select path="artists">
                        <form:option value="0" label="Choose artists" disabled="true"/>
                        <form:options itemValue="id" itemLabel="pseudonym" items="${artists}"/>
                    </form:select>
                </div>
                <div class="form-group">
                    <label><span class="glyphicon glyphicon-pencil"></span></span> Title</label><br>
                    <form:errors path="title" cssClass="error" element="div"/>
                    <form:input path="title"/>
                </div>
                <div class="form-group">
                    <label><i class="fas fa-signature"></i></span> Label</label><br>
                    <form:errors path="label" cssClass="error" element="div"/>
                    <form:select path="label">
                        <form:option value="0" label="Choose label"/>
                        <form:options itemValue="id" itemLabel="name" items="${labels}"/>
                    </form:select>
                </div>
                <div class="form-group">
                    <label><span class="glyphicon glyphicon-calendar"></span> Release date</label><br>
                    <form:errors path="releaseDate" cssClass="error" element="div"/>
                    <form:input type="date" path="releaseDate"/>
                </div>
                <div class="form-group">
                    <label><span class="glyphicon glyphicon-cd"></span></span> Format</label><br>
                    <form:errors path="format" cssClass="error" element="div"/>
                    <form:select path="format" items="${formats}"/>
                </div>
                <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-cd"></span> Edit album</button>
            </form:form>
        </div>
        <div class="modal-footer">
            <%--            <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>--%>
            <p><a href="/albums/all" style="padding: auto">Back to albums</a></p>
        </div>
    </div>
</div>


<%--
<form:form method="post" action="/albums/edit" modelAttribute="album">
    <form:hidden path="id"/>
    <%@include file="albumAddForm.jsp"%>
</form:form>
--%>

<%--<%@include file="../modals/login.jsp"%>
<%@include file="../modals/register.jsp"%>--%>
<%@include file="../footer.jsp"%>

</body>
</html>
