<table border="1" style="text-align: center; margin: 0 auto; border-width: medium;" cellpadding = "10">
    <tr>
        <td>Name</td>
        <td><form:input path="name"/></td>
        <td><form:errors path="name" cssClass="error" element="div"/></td>
    </tr>
    <tr>
        <td>Country</td>
        <td><form:select path="country" items="${countries}"/></td>
        <td><form:errors path="country" cssClass="error" element="div"/></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="add"></td>
    </tr>
</table>