<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
    <%@include file="utils/files.jsp"%>
</head>
<body>

<%@include file="sections/header/header.jsp"%>

<div class="container" id="register-container">

    <div class="modal-content" id="register-content">
        <div class="modal-header" style="padding:35px 50px;">
            <h4><span class="glyphicon glyphicon-pencil"></span> Register</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
            <form:form action="${pageContext.request.contextPath}/register" method="post" modelAttribute="userDto">
                <div class="form-group">
                    <label for="email"><span class="glyphicon glyphicon-envelope"></span> E-mail</label>
                    <br><form:errors path="email" cssClass="error"/>
                    <c:if test="${emailexists}">
                        <br><span class="error">E-mail address is already in use</span>
                    </c:if>
                    <form:input path="email" class="form-control" placeholder="Enter email" id="email"/>
                </div>
                <div class="form-group">
                    <label for="username"><span class="glyphicon glyphicon-user"></span> Login</label>
                    <c:if test="${usernameexists}">
                        <br><span class="error">Login is already in use</span>
                    </c:if>
                    <br><form:errors path="username" cssClass="error"/>
                    <form:input path="username" class="form-control" placeholder="Enter username" id="username"/>
                </div>
                <div class="form-group">
                    <label for="psw1"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                    <br><form:errors path="password" cssClass="error"/>
                    <c:if test="${usernameeqpass}">
                        <br><span class="error">Login and password must differ</span>
                    </c:if>
                    <form:password path="password" class="form-control" placeholder="Enter password" id="psw1"/>
                </div>
                <div class="form-group">
                    <label for="psw2"><span class="glyphicon glyphicon-eye-open"></span> Confirm password</label>
                        <%--TODO: atrybut chyba nie działa--%>
                    <c:if test="${passwordseq}">
                        <br><span class="error">Passwords must be equal</span>
                    </c:if>
                    <form:password path="matchingPassword" class="form-control" placeholder="Confirm password" id="psw2"/>
                </div>
                <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-pencil"></span> Register</button>

            </form:form>
        </div>
        <div class="modal-footer">
            <p>Already have an account? <a href="${pageContext.request.contextPath}/login" data-toggle="modal" data-dismiss="modal">Sign in</a></p>
        </div>
    </div>
</div>

<%@include file="sections/footer.jsp"%>
</body>
</html>