<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lost password</title>
    <%@include file="utils/files.jsp"%>
</head>
<body>

<div id="outer-container">
    <%@include file="sections/header/header.jsp"%>

    <div id="body">

        <div class="container" id="register-container">

            <!-- Modal content-->
            <div class="modal-content" id="register-content">
                <div class="modal-header" style="padding:35px 50px;">
                    <%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
                    <h4><span class="glyphicon glyphicon-pencil"></span> Retrieve password</h4>
                </div>
                <div class="modal-body" style="padding:40px 50px;">
                    <form action="${pageContext.request.contextPath}/lostpassword" method="post">
                        <div class="form-group">
                            <label for="email-login"><span class="glyphicon glyphicon-envelope"></span> E-mail address/login</label>
                            <c:if test="${wrongemailorlogin}">
                                <br><span class="error">No user with given e-mail address or login found</span>
                            </c:if>
                            <input type="text" name="email-login" class="form-control" id="email-login" placeholder="Enter e-mail address or login">
                        </div>
                        <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-pencil"></span> Retrieve password</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <%--            <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>--%>
                    <p><a href="${pageContext.request.contextPath}/login" data-toggle="modal" data-dismiss="modal">Back to login panel</a></p>
                </div>
            </div>
        </div>

    </div>
    <%@include file="sections/footer.jsp"%>
</div>

</body>
</html>
