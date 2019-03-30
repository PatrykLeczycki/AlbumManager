<tr>
    <c:if test="${sessionScope.admin}">
        <td>${album.id}</td>
    </c:if>
    <td>${album.getArtistsToString()}</td>
    <td>${album.title}</td>
    <td>${album.label.name}</td>
    <td>${album.releaseDate}</td>
    <td>${album.format}</td>
    <c:if test="${sessionScope.admin}">
        <td><a href="/admin/editalbum/${album.id}"><span class="glyphicon glyphicon-edit"/></a></td>
        <td><a href="/admin/deletealbum/${album.id}" onclick="return confirm('Are you sure you want to delete this album?');"><span class="glyphicon glyphicon-trash"/></a></td>
    </c:if>

    <c:set var="contains" value="false"/>
    <c:forEach items="${useralbumsids}" var="id">
        <c:if test="${id eq album.id}">
            <c:set var="contains" value="true"/>
        </c:if>
    </c:forEach>

        <c:choose>

            <c:when test="${contains == true}">

                <c:if test="${sessionScope.admin}">
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/deletealbumfromcollection/${album.id}" onclick="return confirm('Are you sure you want to remove this album from your collection?');"><span class="glyphicon glyphicon-minus"/></a>
                    </td>
                </c:if>
                <c:if test="${sessionScope.user}">
                    <td>
                        <a href="${pageContext.request.contextPath}/user/deletealbumfromcollection/${album.id}" onclick="return confirm('Are you sure you want to remove this album from your collection?');"><span class="glyphicon glyphicon-minus"/></a>
                    </td>
                </c:if>

            </c:when>

            <c:otherwise>

                <c:if test="${sessionScope.admin}">
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/addalbumtocollection/${album.id}" onclick="return confirm('Are you sure you want to add this album to your collection?');"><span class="glyphicon glyphicon-plus"/></a>
                    </td>
                </c:if>
                <c:if test="${sessionScope.user}">
                    <td>
                        <a href="${pageContext.request.contextPath}/user/addalbumtocollection/${album.id}" onclick="return confirm('Are you sure you want to add this album to your collection?');"><span class="glyphicon glyphicon-plus"/></a>
                    </td>
                </c:if>

            </c:otherwise>

        </c:choose>
</tr>