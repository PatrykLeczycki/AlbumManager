
<c:if test="${loggedUserId != user.id}">
    <tr>
        <td>${user.id}</td>
        <td>${user.login}</td>
        <td>${user.email}</td>
        <c:choose>
            <c:when test="${user.admin}">
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

