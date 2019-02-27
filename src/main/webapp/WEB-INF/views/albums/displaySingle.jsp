<tr>
    <td>${album.id}</td>
    <td>${album.getArtistsToString()}</td>
    <td>${album.title}</td>
    <td>${album.label.name}</td>
    <td>${album.releaseDate}</td>
    <td>${album.format}</td>
    <td><a href="/albums/edit/${album.id}">Edit</a></td>
    <td><a href="/albums/delete/${album.id}" onclick="return confirm('Are you sure you want to delete this album?');">Delete</a></td>
    <c:set var="contains" value="false"/>
    <c:forEach items="${useralbumsids}" var="id">
        <c:if test="${id eq album.id}">
            <c:set var="contains" value="true"/>
        </c:if>
    </c:forEach>
    <td>
        <c:choose>
            <c:when test="${contains == true}">
                <a href="/user/deletealbum/${album.id}" onclick="return confirm('Are you sure you want to remove this album from your collection?');">Remove from collection</a>
            </c:when>
            <c:otherwise>
                <a href="/user/addalbum/${album.id}" onclick="return confirm('Are you sure you want to add this album to your collection?');">Add to collection</a>
            </c:otherwise>
        </c:choose>
    </td>

</tr>