
<form:hidden path="id"/>
<div class="form-group">
    <label><i class="fas fa-users"></i> Pseudonym</label><br>
    <form:errors path="pseudonym" cssClass="error" element="div"/>
    <form:input path="pseudonym"/>
</div>
<div class="form-group">
    <label><i class="fas fa-signature"></i>  Name</label><br>
    <form:errors path="name" cssClass="error" element="div"/>
    <form:input path="name"/>
</div>
<div class="form-group">
    <label><i class="fas fa-signature"></i> Surname</label><br>
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
    <td><form:select path="nationality" items="${countries}" class="multi-select-demo"/></td>
    <form:errors path="nationality" cssClass="error" element="div"/>
</div>
<button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-cd"></span> Add artist</button>

<script type="text/javascript">

    $(document).ready(function() {
        $('.multi-select-demo').multiselect();
    });

</script>

