<tr>
    <sec:authorize access="hasRole('USER') && hasRole('ADMIN')">
        <td>${artist.id}</td>
    </sec:authorize>
    <td>${artist.pseudonym}</td>
    <td>${artist.name}</td>
    <td>${artist.surname}</td>
    <td>
        <c:choose>
            <c:when test="${not empty artist.birthDate}">
                ${artist.birthDate}
            </c:when>
            <c:otherwise>
                N/A
            </c:otherwise>
        </c:choose>
    </td>
    <td>
        <c:choose>
            <c:when test="${not empty artist.age}">
                ${artist.age}
            </c:when>
            <c:otherwise>
                N/A
            </c:otherwise>
        </c:choose>
    </td>
    <td>${artist.sex}</td>
    <td>${artist.nationality}</td>
    <sec:authorize access="hasRole('USER') && hasRole('ADMIN')">
        <td><a href="${pageContext.request.contextPath}/admin/editartist/${artist.id}"><span class="glyphicon glyphicon-edit"/></a></td>
        <td><a href="${pageContext.request.contextPath}/admin/deleteartist/${artist.id}" onclick="return confirm('Are you sure you want to delete this artist?');"><span class="glyphicon glyphicon-trash"/></a></td>
    </sec:authorize>
</tr>