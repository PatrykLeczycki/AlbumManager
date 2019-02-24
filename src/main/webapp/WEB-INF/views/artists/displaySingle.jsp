<tr>
    <td>${artist.id}</td>
    <td>${artist.pseudonym}</td>
    <td>${artist.name}</td>
    <td>${artist.surname}</td>
    <td>${artist.age}</td>
    <td>${artist.sex}</td>
    <td>${artist.nationality}</td>
    <td><a href="/artists/edit/${artist.id}">Edit</a></td>
    <td><a href="/artists/delete/${artist.id}" onclick="return confirm('Are you sure you want to delete this artist?');">Delete</a></td>
</tr>