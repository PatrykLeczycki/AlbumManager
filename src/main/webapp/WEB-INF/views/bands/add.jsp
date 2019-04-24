<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add band</title>
    <%@include file="../utils/files.jsp"%>
</head>
<body>

<div id="outer-container">
    <%@include file="../sections/header/header.jsp"%>

    <div id="body">
        <div class="container" id="register-container">
            <div class="modal-content" id="register-content">
                <div class="modal-header" style="padding:35px 50px;">
                    <h4><span class="glyphicon glyphicon-cd"></span> Add band</h4>
                </div>


                <div class="modal-body" style="padding:40px 50px;">
                    <form:form method="post" action="/user/addband" modelAttribute="band">
                        <%@include file="bandAddForm.jsp"%>
                    </form:form>
                </div>
                <div class="modal-footer">
                    <p><a href="${pageContext.request.contextPath}/bands/all" style="padding: auto">Back to bands</a></p>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../sections/footer.jsp"%>

</div>
</body>
</html>
