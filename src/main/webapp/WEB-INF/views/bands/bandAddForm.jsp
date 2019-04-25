
<form:hidden path="id"/>
<div class="form-group">
    <label><i class="fas fa-signature"></i> Name</label><br>
    <form:errors path="name" cssClass="error" element="div"/>
    <form:input path="name"/>
</div>
<div class="form-group">
    <label><i class="fas fa-users"></i> Members</label>
    <form:errors path="members" cssClass="error" element="div"/><br>
    <form:select path="members" class="multi-select-demo">
        <form:options itemValue="id" itemLabel="pseudonym" items="${artists}"/>
    </form:select>
</div>

<%-- TODO: rozdzielić formularz dodawania i edytowania - guziki "Add band" i "Edit band"--%>

<button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-cd"></span> Add band</button>

<script type="text/javascript">

    $(document).ready(function() {
        $('.multi-select-demo').multiselect();
    });

</script>