<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
    <%@include file="utils/files.jsp"%>
    <%@include file="sections/modal.jsp"%>
</head>
<body>

<div id="outer-container">
    <%@include file="sections/header/header.jsp"%>

    <div id="body">
        <c:if test="${registersuccess || recoverymailsent || linkcorrupted || passwordchanged}">
            <div class="container" id="register-container">
                <div class="modal-content" id="register-content">
                    <div class="modal-header" style="padding: 0;">
                        <p class="modal-body error" style="text-align: center; background-color: white; ">
                            <c:if test="${registersuccess}">
                                Thank you for registration. Please activate your account with link sent on given e-mail address.
                            </c:if>
                            <c:if test="${recoverymailsent}">
                                We have sent mail with password retrieve link on given e-mail address.
                            </c:if>
                            <c:if test="${linkcorrupted}">
                                Error - link is corrupted.
                            </c:if>
                            <c:if test="${passwordchanged}">
                                Password has been changed.
                            </c:if>
                        </p>
                    </div>
                </div>
            </div>
            <br>
        </c:if>

        <div class="container" id="login-container">
            <div class="modal-content" id="login-content">
                <div class="modal-header" style="padding:35px 50px;">
                    <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
                </div>
                <div class="modal-body" style="padding:40px 50px;">

                    <form action="${pageContext.request.contextPath}/perform_login" method="post">
                        <div class="form-group">
                            <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
                            <c:if test="${param.error}">
                                ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
                            </c:if>
                            <input type="text" name="username" class="form-control" id="usrname" placeholder="Enter username">
                        </div>
                        <div class="form-group">
                            <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                            <input type="password" name="password" class="form-control" id="psw" placeholder="Enter password">
                        </div>
                        <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
                    </form>

                </div>
                <div class="modal-footer">
                    <p>Not a member? <a href="${pageContext.request.contextPath}/register" data-toggle="modal" data-dismiss="modal">Sign up</a></p>
                    <p>Forgot <a href="${pageContext.request.contextPath}/lostpassword">password?</a></p>
                </div>
            </div>
        </div>

    </div>
    <%@include file="sections/footer.jsp"%>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
