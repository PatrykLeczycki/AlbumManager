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

<div class="container" id="login-container">
    <div class="modal-content" id="login-content">
        <div class="modal-header" style="padding:35px 50px;">
            <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">

            <form action="/login" method="post">
                <div class="form-group">
                    <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
                    <c:if test="${loginerror}">
                        <br><span class="error">Incorrect login or password</span>
                    </c:if>
                    <input type="text" name="login" class="form-control" id="usrname" placeholder="Enter login">
                </div>
                <div class="form-group">
                    <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                    <input type="password" name="password" class="form-control" id="psw" placeholder="Enter password">
                </div>
                <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
            </form>

        </div>
        <div class="modal-footer">
            <p>Not a member? <a href="/register" data-toggle="modal" data-dismiss="modal">Sign up</a></p>
            <p>Forgot <a href="/lostpassword">password?</a></p>
        </div>
    </div>
</div>
<%--<script>
    $(document).ready(function(){
        $("#myBtn").click(function(){
            $("#myModal").modal();
        });
    });
</script>--%>

<%--<%@include file="../modals/login.jsp"%>--%>
<%--<%@include file="../modals/register.jsp"%>--%>
<%@include file="../footer.jsp"%>
</body>
</html>
