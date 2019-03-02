<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
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
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4><span class="glyphicon glyphicon-pencil"></span> Register</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
            <form action="/register" method="post">
                <div class="form-group">
                    <label for="email"><span class="glyphicon glyphicon-envelope"></span> E-mail</label>
                    <c:if test="${sessionScope.emailpattern}">
                        <br><span class="error">Wrong e-mail format</span>
                    </c:if>
                    <c:if test="${sessionScope.emailexists}">
                        <br><span class="error">E-mail address is already in use</span>
                    </c:if>
                    <input type="text" name="email" class="form-control" id="email" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="login"><span class="glyphicon glyphicon-user"></span> Login</label>
                    <c:if test="${sessionScope.loginexists}">
                        <br><span class="error">Login is already in use</span>
                    </c:if>
                    <c:if test="${sessionScope.loginlength}">
                        <br><span class="error">Login must have at least 5 characters</span>
                    </c:if>
                    <input type="text" class="form-control" name="login" id="login" placeholder="Enter login">
                </div>
                <div class="form-group">
                    <label for="psw1"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                    <c:if test="${sessionScope.passlength}">
                        <br><span class="error">Password must have at least 8 characters</span>
                    </c:if>
                    <c:if test="${sessionScope.logineqpass}">
                        <br><span class="error">Login and password must differ</span>
                    </c:if>
                    <input type="password" class="form-control" name="password1" id="psw1" placeholder="Enter password">
                </div>
                <div class="form-group">
                    <label for="psw2"><span class="glyphicon glyphicon-eye-open"></span> Confirm password</label>
                    <%--TODO: atrybut chyba nie działa--%>
                    <c:if test="${sessionScope.passwordseq}">
                        <br><span class="error">Passwords must be equal</span>
                    </c:if>
                    <input type="password" class="form-control" name="password2" id="psw2" placeholder="Confirm password">
                </div>
                <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-pencil"></span> Register</button>
            </form>
        </div>
        <div class="modal-footer">
            <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
            <p>Already have an account? <a href="/login" data-toggle="modal" data-dismiss="modal">Sign in</a></p>
        </div>
    </div>
<h1>BLA BLA BLA BLA</h1>
</div>

<%--<%@include file="../modals/login.jsp"%>
<%@include file="../modals/register.jsp"%>--%>
<%@include file="../footer.jsp"%>
</body>
</html>
