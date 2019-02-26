<tr>
    <td>${album.id}</td>
    <td>${album.getArtistsToString()}</td>
    <td>${album.title}</td>
    <td>${album.label.name}</td>
    <td>${album.releaseDate}</td>
    <td>${album.format}</td>
    <td><a href="/albums/edit/${album.id}">Edit</a></td>
    <td><a href="/albums/delete/${album.id}" onclick="return confirm('Are you sure you want to delete this album?');">Delete</a></td>
    <td><a href="/user/add/${album.id}" onclick="return confirm('Are you sure you want to add this album to your collection?');">Add to collection</a></td>
</tr>