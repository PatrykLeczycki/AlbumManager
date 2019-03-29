<tr>
    <c:if test="${sessionScope.admin}">
        <td>${label.id}</td>
    </c:if>
    <td>${label.name}</td>
    <td>${label.country}</td>
    <c:if test="${sessionScope.admin}">
        <td><a href="${pageContext.request.contextPath}/labels/edit/${label.id}">Edit</a></td>
        <td><a href="${pageContext.request.contextPath}/labels/delete/${label.id}" onclick="return confirm('Are you sure you want to delete this label?');">Delete</a></td>

    </c:if>

</tr>