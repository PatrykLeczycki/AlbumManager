<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="!isAuthenticated()">
    <%@include file="unloggedHeader.jsp"%>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <%@include file="userHeader.jsp"%>
</sec:authorize>
