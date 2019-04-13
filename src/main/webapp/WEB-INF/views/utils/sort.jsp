<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="!isAuthenticated()">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/sortSixCols.js"></script>
</sec:authorize>
<sec:authorize access="hasRole('USER') && hasRole('ADMIN')">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/sortNineCols.js"></script>
</sec:authorize>
<sec:authorize access="hasRole('USER') && !hasRole('ADMIN')">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/sortSevenCols.js"></script>
</sec:authorize>