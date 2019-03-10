<div class="modal-body" style="padding:40px 50px;">
    <form:form method="post" action="/artists/add" modelAttribute="label">
        <div class="form-group">
            <label><i class="fas fa-users"></i></span> Name</label><br>
            <form:errors path="name" cssClass="error" element="div"/>
            <form:input path="name"/>
        </div>
        <div class="form-group">
            <label><span class="glyphicon glyphicon-pencil"></span></span> Country</label><br>
            <form:errors path="country" cssClass="error" element="div"/>
            <form:select path="country" items="${countries}"/>
        </div>
        <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-cd"></span> Add artist</button>
    </form:form>
</div>
<div class="modal-footer">
    <p><a href="/labels/all" style="padding: auto">Back to labels</a></p>
</div>