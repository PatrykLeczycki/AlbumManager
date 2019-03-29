<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit artist</title>
    <%@include file="../files.jsp"%>
</head>
<body>

<%@include file="../header.jsp"%>

<div class="container" id="register-container">
    <div class="modal-content" id="register-content">
        <div class="modal-header" style="padding:35px 50px;">
            <h4><span class="glyphicon glyphicon-cd"></span> Edit artist</h4>
        </div>

        <div class="modal-body" style="padding:40px 50px;">
            <form:form method="post" action="/admin/editartist" modelAttribute="artist">
                <%@include file="artistAddForm.jsp"%>
            </form:form>

        </div>
        <div class="modal-footer">
            <p><a href="${pageContext.request.contextPath}/artists/all" style="padding: auto">Back to all artists</a></p>
        </div>

    </div>
</div>

<%@include file="../footer.jsp"%>

</body>
</html>
