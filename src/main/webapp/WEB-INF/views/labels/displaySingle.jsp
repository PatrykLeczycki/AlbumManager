<tr>
    <sec:authorize access="hasRole('USER') && hasRole('ADMIN')">
        <td>${label.id}</td>
    </sec:authorize>
    <td>${label.name}</td>
    <td>${label.country}</td>
    <sec:authorize access="hasRole('USER') && hasRole('ADMIN')">
        <td><a href="${pageContext.request.contextPath}/admin/editlabel/${label.id}"><span class="glyphicon glyphicon-edit"/></a></td>
        <td><a href="${pageContext.request.contextPath}/admin/deletelabel/${label.id}" onclick="return confirm('Are you sure you want to delete this label?');"><span class="glyphicon glyphicon-trash"/></a></td>
    </sec:authorize>
</tr>