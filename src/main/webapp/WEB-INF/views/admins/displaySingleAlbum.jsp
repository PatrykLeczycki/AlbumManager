
<c:set var="contains" value="false"/>
<c:forEach items="${adminalbumids}" var="adminalbumid">
    <c:if test="${adminalbumid eq album.id}">
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
    <td><a href="${pageContext.request.contextPath}/admin/editalbum/${album.id}"><span class="glyphicon glyphicon-edit"/></a></td>
    <td><a href="${pageContext.request.contextPath}/admin/deletealbum/${album.id}" onclick="return confirm('Are you sure you want to delete this album?');"><span class="glyphicon glyphicon-trash"/></a></td>
    <td><a href="${pageContext.request.contextPath}/admin/collectiondeletealbum/${album.id}?back=true" onclick="return confirm('Are you sure you want to remove this album from your collection?');"><span class="glyphicon glyphicon-minus-sign"/></a></td>
</c:if>