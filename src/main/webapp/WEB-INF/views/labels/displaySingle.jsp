<tr>
    <td>${label.id}</td>
    <td>${label.name}</td>
    <td>${label.country}</td>
    <td><a href="${pageContext.request.contextPath}/labels/edit/${label.id}">Edit</a></td>
    <td><a href="${pageContext.request.contextPath}/labels/delete/${label.id}" onclick="return confirm('Are you sure you want to delete this label?');">Delete</a></td>
</tr>