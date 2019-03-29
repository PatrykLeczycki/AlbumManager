<tr>
    <c:if test="${sessionScope.admin}">
        <td>${label.id}</td>
    </c:if>
    <td>${label.name}</td>
    <td>${label.country}</td>
    <c:if test="${sessionScope.admin}">
        <td><a href="${pageContext.request.contextPath}/admin/editlabel/${label.id}"><span class="glyphicon glyphicon-edit"/></a></td>
        <td><a href="${pageContext.request.contextPath}/admin/deletelabel/${label.id}" onclick="return confirm('Are you sure you want to delete this label?');"><span class="glyphicon glyphicon-trash"/></a></td>

    </c:if>

</tr>