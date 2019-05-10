<tr>
    <sec:authorize access="hasRole('USER') && hasRole('ADMIN')">
        <td>${album.id}</td>
    </sec:authorize>
    <td>
        <c:choose>
            <c:when test="${album.band != null}">
                ${album.band.name}
            </c:when>
            <c:otherwise>
                ${album.getArtistsToString()}
            </c:otherwise>
        </c:choose>
    </td>
    <td>${album.title}</td>
    <td>${album.label.name}</td>
    <td>${album.releaseDate}</td>
    <td>${album.format}</td>
    <sec:authorize access="hasRole('USER') && hasRole('ADMIN')">
        <td><a href="/admin/editalbum/${album.id}"><span class="glyphicon glyphicon-edit"/></a></td>
        <td><a href="/admin/deletealbum/${album.id}" onclick="return confirm('Are you sure you want to delete this album?');"><span class="glyphicon glyphicon-trash"/></a></td>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <c:set var="contains" value="false"/>
        <c:forEach items="${useralbumsids}" var="id">
            <c:if test="${id eq album.id}">
                <c:set var="contains" value="true"/>
            </c:if>
        </c:forEach>

        <c:choose>

            <c:when test="${contains}">
                <td>
                    <a href="${pageContext.request.contextPath}/user/deletealbumfromcollection/${album.id}" onclick="return confirm('Are you sure you want to remove this album from your collection?');"><span class="glyphicon glyphicon-minus"/></a>
                </td>
            </c:when>
            <c:otherwise>
                <td>
                    <a href="${pageContext.request.contextPath}/user/addalbumtocollection/${album.id}" onclick="return confirm('Are you sure you want to add this album to your collection?');"><span class="glyphicon glyphicon-plus"/></a>
                </td>
            </c:otherwise>

        </c:choose>
    </sec:authorize>
</tr>