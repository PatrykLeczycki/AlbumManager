<form:hidden path="id"/>
<div class="form-group">
    <label><i class="fas fa-users"></i> Name</label><br>
    <form:errors path="name" cssClass="error" element="div"/>
    <form:input path="name"/>
</div>
<div class="form-group">
    <label><span class="glyphicon glyphicon-pencil"></span> Country</label><br>
    <form:errors path="country" cssClass="error" element="div"/>
    <form:select path="country" items="${countries}" class="multi-select-demo"/>
</div>
<button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-cd"></span> Add artist</button>

<script type="text/javascript">

    $(document).ready(function() {
        $('.multi-select-demo').multiselect();
    });

</script>
