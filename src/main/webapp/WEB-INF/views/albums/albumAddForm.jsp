
<form:hidden path="id"/>
<div class="form-group">
    <label><i class="fas fa-users"></i>Artists</label>
    <form:errors path="artists" cssClass="error" element="div"/><br>
    <form:select path="artists">
        <form:option value="0" label="Choose artists" disabled="true"/>
        <form:options itemValue="id" itemLabel="pseudonym" items="${artists}"/>
    </form:select>
</div>
<div class="form-group">
    <label><span class="glyphicon glyphicon-pencil"></span> Title</label><br>
    <form:errors path="title" cssClass="error" element="div"/>
    <form:input path="title"/>
</div>
<div class="form-group">
    <label><i class="fas fa-signature"></i></span> Label</label><br>
    <form:errors path="label" cssClass="error" element="div"/>
    <form:select path="label">
        <form:option value="0" label="Choose label"/>
        <form:options itemValue="id" itemLabel="name" items="${labels}"/>
    </form:select>
</div>
<div class="form-group">
    <label><span class="glyphicon glyphicon-calendar"></span> Release date</label><br>
    <form:errors path="releaseDate" cssClass="error" element="div"/>
    <form:input type="date" path="releaseDate"/>
</div>
<%--TODO: dodać opcję dodaj/wybierz z istniejącą--%>
<%--<div class="form-group">
    <label><span class="glyphicon glyphicon-cd"></span></span> Genre</label><br>
    <form:errors path="genre" cssClass="error" element="div"/>
    <form:select path="genre" items="${formats}"/>
</div>--%>
<div class="form-group">
    <label><span class="glyphicon glyphicon-list-alt"></span> Genre</label><br>
    <form:errors path="genre" cssClass="error" element="div"/>
    <form:input path="genre"/>
</div>
<div class="form-group">
    <label><span class="glyphicon glyphicon-cd"></span> Format</label><br>
    <form:errors path="format" cssClass="error" element="div"/>
    <form:select path="format" items="${formats}"/>
</div>
<button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-cd"></span> Edit album</button>