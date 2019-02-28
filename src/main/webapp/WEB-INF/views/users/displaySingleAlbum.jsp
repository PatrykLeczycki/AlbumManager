<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</c:if>