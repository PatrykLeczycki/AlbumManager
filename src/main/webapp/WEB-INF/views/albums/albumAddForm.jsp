<table cellpadding = "10">

    <tr>
        <td>Artists</td>
        <td>
            <form:select path="artists">
                <form:option value="0" label="Choose artists" disabled="true"/>
                <form:options itemValue="id" itemLabel="pseudonym" items="${artists}"/>
            </form:select>
        </td>
        <td><form:errors path="artists" cssClass="error" element="div"/></td>
    </tr>
    <tr>
        <td>Title</td>
        <td><form:input path="title"/></td>
        <td><form:errors path="title" cssClass="error" element="div"/></td>
    </tr>
    <tr>
        <td>Label</td>
        <td>
            <form:select path="label">
                <form:option value="0" label="Choose label"/>
                <form:options itemValue="id" itemLabel="name" items="${labels}"/>
            </form:select>
        </td>
        <td><form:errors path="label" cssClass="error" element="div"/></td>
    </tr>
    <tr>
        <td>Release date</td>
        <td><form:input type="date" path="releaseDate"/></td>
        <td><form:errors path="releaseDate" cssClass="error" element="div"/></td>
    </tr>
    <tr>
        <td>Format</td>
        <td><form:select path="format" items="${formats}"/></td>
        <td><form:errors path="format" cssClass="error" element="div"/></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="add"></td>
    </tr>
</table>