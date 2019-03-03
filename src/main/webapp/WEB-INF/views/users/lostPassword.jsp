<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lost password</title>
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
            <h4><span class="glyphicon glyphicon-pencil"></span> Retrieve password</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
            <form action="/lostpassword" method="post">
                <div class="form-group">
                    <label for="email"><span class="glyphicon glyphicon-envelope"></span> E-mail</label>
                   <%-- <c:if test="${sessionScope.emailpattern}">
                        <br><span class="error">Wrong e-mail format</span>
                    </c:if>--%>
                    <input type="text" name="email" class="form-control" id="email" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="login"><span class="glyphicon glyphicon-user"></span> Login</label>
                    <input type="text" class="form-control" name="login" id="login" placeholder="Enter login">
                </div>
                <div class="form-group">
                    <label for="newPassword"><span class="glyphicon glyphicon-eye-open"></span> New password</label>
                    <input type="password" class="form-control" name="newPassword" id="newPassword" placeholder="Enter password">
                </div>
                <div class="form-group">
                    <label for="newPasswordRepeat"><span class="glyphicon glyphicon-eye-open"></span> Confirm new password</label>
                    <input type="password" class="form-control" name="newPasswordRepeat" id="newPasswordRepeat" placeholder="Confirm password">
                </div>
                <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-pencil"></span> Retrieve password</button>
            </form>
        </div>
        <div class="modal-footer">
            <%--            <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>--%>
            <p><a href="/login" data-toggle="modal" data-dismiss="modal">Back to login panel</a></p>
        </div>
    </div>
</div>

<%--<form action="/user/lostpassword" method="post">

    <table border="1" style="text-align: center; border-width: medium; margin: 0 auto" cellpadding = "10">
        <tr>
            <td>E-mail</td>
            <td><input name="email" type="text"/></td>
            <td></td>
        </tr>

        <tr>
            <td>Login</td>
            <td><input name="login" type="text"/></td>
            <td></td>
        </tr>
        <tr>
            <td>New password</td>
            <td><input name="newPassword" type="password"/><br/></td>
            <td></td>
        </tr>
        <tr>
            <td>Confirm new password</td>
            <td><input name="newPasswordRepeat" type="password"/><br/></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>--%>

<%--<%@include file="../modals/login.jsp"%>--%>
<%@include file="../modals/register.jsp"%>
<%@include file="../footer.jsp"%>

</body>
</html>
