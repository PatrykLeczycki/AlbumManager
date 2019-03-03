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
    <title>Add artist</title>
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
            <h4><span class="glyphicon glyphicon-cd"></span> Add artist</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
            <form:form method="post" action="/artists/add" modelAttribute="artist">
                <div class="form-group">
                    <label><i class="fas fa-users"></i></span> Pseudonym</label><br>
                    <form:errors path="pseudonym" cssClass="error" element="div"/>
                    <form:input path="pseudonym"/>
                </div>
                <div class="form-group">
                    <label><span class="glyphicon glyphicon-pencil"></span></span> Name</label><br>
                    <form:errors path="name" cssClass="error" element="div"/>
                    <form:input path="name"/>
                </div>
                <div class="form-group">
                    <label><i class="fas fa-signature"></i></span> Surname</label><br>
                    <form:errors path="surname" cssClass="error" element="div"/>
                    <form:input path="surname"/>
                </div>
                <div class="form-group">
                    <label><span class="glyphicon glyphicon-calendar"></span> Age</label><br>
                    <form:errors path="age" cssClass="error" element="div"/>
                    <form:input path="age" placeholder=""/>
                </div>
                <div class="form-group">
                    <label><i class="fas fa-venus-mars"></i> Sex</label><br>
                    Male: <form:radiobutton path="sex" value="Male"/><br>
                    Female: <form:radiobutton path="sex" value="Female"/>
                    <form:errors path="sex" cssClass="error" element="div"/>
                </div>
                <div class="form-group">
                    <label><span class="glyphicon glyphicon-globe"></span> Nationality</label><br>
                    <td><form:select path="nationality" items="${countries}"/></td>
                    <form:errors path="nationality" cssClass="error" element="div"/>
                </div>
                <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-cd"></span> Add artist</button>
            </form:form>
        </div>
        <div class="modal-footer">
            <%--            <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>--%>
            <p><a href="/artists/all" style="padding: auto">Back to all artists</a></p>
        </div>
    </div>
</div>


<%--<form:form method="post" action="/artists/add" modelAttribute="artist">
    <%@include file="artistAddForm.jsp"%>
</form:form>--%>

<%--<%@include file="../modals/login.jsp"%>--%>
<%--<%@include file="../modals/register.jsp"%>--%>
<%@include file="../footer.jsp"%>

</body>
</html>