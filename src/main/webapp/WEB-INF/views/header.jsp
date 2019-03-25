<c:choose>
    <c:when test="${sessionScope.admin}">
        <%@include file="adminHeader.jsp"%>
        <%--<div class="container" id="register-container">
            <div class="modal-content" id="register-content1">
                <div class="modal-header" style="padding:35px 50px;">
                    <h4><i class="fas fa-hand-paper"></i></span> Welcome, ${login}</h4>
                </div>
            </div>
        </div>--%>
    </c:when>
    <c:when test="${sessionScope.user}">
        <%@include file="userHeader.jsp"%>
        <%--<div class="container" id="register-container">
            <div class="modal-content" id="register-content">
                <div class="modal-header" style="padding:35px 50px;">
                    <h4><i class="fas fa-hand-paper"></i></span> Welcome, ${login}</h4>
                </div>
            </div>
        </div>--%>
    </c:when>
    <c:otherwise>
        <%@include file="unloggedHeader.jsp"%>
    </c:otherwise>
</c:choose>