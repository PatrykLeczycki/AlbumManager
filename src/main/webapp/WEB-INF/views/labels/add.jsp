<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add label</title>
    <%@include file="../files.jsp"%>
</head>
<body>
<%@include file="../header.jsp"%>

<div class="container" id="register-container">
    <div class="modal-content" id="register-content">
        <div class="modal-header" style="padding:35px 50px;">
            <h4><span class="glyphicon glyphicon-cd"></span> Add label</h4>
        </div>
        <%@include file="labelAddForm.jsp"%>
    </div>
</div>

<%@include file="../footer.jsp"%>

</body>
</html>