

<c:set var="contains" value="false"/>
<c:forEach items="${useralbumids}" var="useralbumid">
    <c:if test="${useralbumid eq album.id}">
        <c:set var="contains" value="true"/>
    </c:if>
</c:forEach>

<c:if test="${contains == true}">
    <tr>
    <td>${album.id}</td>
    <td>${album.getArtistsToString()}</td>
    <td>${album.title}</td>
    <td>${album.label.name}</td>
    <td>${album.releaseDate}</td>
    <td>${album.format}</td>
    <td><a href="/user/deletealbum/${album.id}?back=true" onclick="return confirm('Are you sure you want to remove this album from your collection?');">Remove from collection</a></td>
</c:if>