<table style="text-align: center">

    <tr>
        <td>Pseudonym</td>
        <td><form:input path="pseudonym"/></td>
        <td><form:errors path="pseudonym" cssClass="error" element="div"/></td>
    </tr>
    <tr>
        <td>Name</td>
        <td><form:input path="name"/></td>
        <td><form:errors path="name" cssClass="error" element="div"/></td>
    </tr>
    <tr>
        <td>Surname</td>
        <td><form:input path="surname"/></td>
        <td><form:errors path="surname" cssClass="error" element="div"/></td>
    </tr>
    <tr>
        <td>Age</td>
        <td><form:input path="age"/></td>
        <td><form:errors path="age" cssClass="error" element="div"/></td>
    </tr>
    <tr>
        <td>Sex</td>
        <td>
            Male: <form:radiobutton path="sex" value="M"/><br>
            Female: <form:radiobutton path="sex" value="F"/>
        </td>
        <td><form:errors path="sex" cssClass="error" element="div"/></td>
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