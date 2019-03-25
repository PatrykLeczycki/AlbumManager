<div class="modal-body" style="padding:40px 50px;">
    <form:form method="post" action="/artists/add" modelAttribute="artist">
        <div class="form-group">
            <label><i class="fas fa-users"></i></span> Pseudonym</label><br>
            <form:errors path="pseudonym" cssClass="error" element="div"/>
            <form:input path="pseudonym"/>
        </div>
        <div class="form-group">
            <label><span class="glyphicon glyphicon-pencil"></span></span> Name</label><br>
            <form:errors path="name" cssClass="error" element="div"/>
            <form:input path="name"/>
        </div>
        <div class="form-group">
            <label><i class="fas fa-signature"></i></span> Surname</label><br>
            <form:errors path="surname" cssClass="error" element="div"/>
            <form:input path="surname"/>
        </div>
        <div class="form-group">
            <label><span class="glyphicon glyphicon-calendar"></span> Birth date</label><br>
            <form:errors path="birthDate" cssClass="error" element="div"/>
            <form:input type="date" path="birthDate"/>
        </div>
        <div class="form-group">
            <label><i class="fas fa-venus-mars"></i> Sex</label><br>
            Male: <form:radiobutton path="sex" value="Male"/><br>
            Female: <form:radiobutton path="sex" value="Female"/>
            <form:errors path="sex" cssClass="error" element="div"/>
        </div>
        <div class="form-group">
            <label><span class="glyphicon glyphicon-globe"></span> Nationality</label><br>
            <td><form:select path="nationality" items="${countries}"/></td>
            <form:errors path="nationality" cssClass="error" element="div"/>
        </div>
        <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-cd"></span> Add artist</button>
    </form:form>
</div>
<div class="modal-footer">
    <p><a href="${pageContext.request.contextPath}/artists/all" style="padding: auto">Back to all artists</a></p>
</div>