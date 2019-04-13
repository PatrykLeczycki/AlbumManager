
<c:if test="${loggedUser != user.username}">
    <c:set var="isAdmin" value="false"/>
    <c:forEach items="${user.roleSet}" var="role">
        <c:if test="${role.name == 'ROLE_ADMIN'}">
            <c:set var="isAdmin" value="true"/>
        </c:if>
    </c:forEach>
    <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.email}</td>
        <c:choose>
            <c:when test="${isAdmin}">
                <td>
                    <a href="${pageContext.request.contextPath}/admin/changerole/${user.id}" onclick="return confirm('Are you sure you want to revoke admin role for chosen user?');"><span class="glyphicon glyphicon-minus"/></a>
                </td>
            </c:when>
            <c:otherwise>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/changerole/${user.id}" onclick="return confirm('Are you sure you want to grant admin role for chosen user?');"><span class="glyphicon glyphicon-plus"/></a>
                </td>
            </c:otherwise>
        </c:choose>
    </tr>
</c:if>

