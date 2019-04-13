<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit album</title>
    <%@include file="../utils/files.jsp"%>
</head>
<body>

<div id="outer-container">
    <%@include file="../sections/header/header.jsp"%>

    <div id="body">
        <div class="container" id="register-container">

            <div class="modal-content" id="register-content">
                <div class="modal-header" style="padding:35px 50px;">
                    <h4><span class="glyphicon glyphicon-cd"></span> Edit album</h4>
                </div>

                <div class="modal-body" style="padding:40px 50px;">
                    <form:form method="post" action="/admin/editalbum" modelAttribute="album">
                        <%@include file="albumAddForm.jsp"%>
                    </form:form>
                </div>
                <div class="modal-footer">
                    <%--            <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>--%>
                    <p><a href="${pageContext.request.contextPath}/albums/all" style="padding: auto">Back to albums</a></p>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../sections/footer.jsp"%>
</div>



</body>
</html>
