<tr>
    <sec:authorize access="hasRole('USER') && hasRole('ADMIN')">
        <td>${band.id}</td>
    </sec:authorize>
    <td>${band.name}</td>
    <td>${band.getMembersToString()}</td>
    <sec:authorize access="hasRole('USER') && hasRole('ADMIN')">
        <td><a href="${pageContext.request.contextPath}/admin/editband/${band.id}"><span class="glyphicon glyphicon-edit"/></a></td>
        <td><a href="${pageContext.request.contextPath}/admin/deleteband/${band.id}" onclick="return confirm('Are you sure you want to delete this band?');"><span class="glyphicon glyphicon-trash"/></a></td>
    </sec:authorize>
</tr>