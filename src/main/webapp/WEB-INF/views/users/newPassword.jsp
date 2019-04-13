<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Use1/4 oglądających r: patryk
  Date: 26.02.19
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New password</title>
    <%@include file="../utils/files.jsp"%>
</head>
<body>

<div id="outer-container">
    <%@include file="../sections/header/header.jsp"%>

    <div id="body">
        <div class="container" id="register-container">

            <!-- Modal content-->
            <div class="modal-content" id="register-content">
                <div class="modal-header" style="padding:35px 50px;">
                    <%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
                    <h4><span class="glyphicon glyphicon-pencil"></span> Change password</h4>
                </div>
                <div class="modal-body" style="padding:40px 50px;">
                    <form action="${pageContext.request.contextPath}/user/newpassword" method="post">
                        <div class="form-group">
                            <label for="oldPassword"><span class="glyphicon glyphicon-eye-open"></span> Old password</label>
                            <%-- <c:if test="${sessionScope.emailpattern}">
                                 <br><span class="error">Wrong e-mail format</span>
                             </c:if>--%>
                            <input type="password" name="oldPassword" class="form-control" id="oldPassword" placeholder="Enter old password">
                        </div>
                        <div class="form-group">
                            <label for="newPassword"><span class="glyphicon glyphicon-eye-open"></span> New password</label>
                            <input type="password" class="form-control" name="newPassword" id="newPassword" placeholder="Enter password">
                        </div>
                        <div class="form-group">
                            <label for="newPasswordRepeat"><span class="glyphicon glyphicon-eye-open"></span> Confirm new password</label>
                            <input type="password" class="form-control" name="newPasswordRepeat" id="newPasswordRepeat" placeholder="Confirm password">
                        </div>
                        <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-pencil"></span> Change password</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <%--            <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>--%>
                    <p><a href="${pageContext.request.contextPath}/user/dashboard" style="padding: auto">Back to dashboard</a></p>
                </div>
            </div>
        </div>

    </div>
    <%@include file="../sections/footer.jsp"%>
</div>


</body>
</html>
