<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="!isAuthenticated()">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/sorts/sortAll.js"></script>
</sec:authorize>
<sec:authorize access="hasRole('USER') && hasRole('ADMIN')">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/sorts/sortAll.js"></script>
</sec:authorize>
<sec:authorize access="hasRole('USER') && !hasRole('ADMIN')">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/sorts/sortAllButLastTwo.js"></script>
</sec:authorize>

