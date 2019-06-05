
<form:hidden path="id"/>

<div class="form-group" style="margin: 0 auto">

    <div id="guzik1" class="btn btn-success <%--btn-block--%> author active">
        Artist
    </div>

    <div id="guzik2" class="btn btn-success <%--btn-block--%> author">
        Band
    </div>

    <div class="clearfix"></div>

</div>

<br>

<c:choose>
    <c:when test="${gotoband}">
        <div class="form-group" id="artist-div" style="display:none">
            <label><i class="fas fa-users"></i> Artists</label>
            <c:if test="${noauthor}">
                <br><span class="error">You must choose artist(s) or band</span>
            </c:if>
            <form:errors path="artists" cssClass="error" element="div"/><br>
            <form:select path="artists" multiple="true" class="multi-select-demo" id="artist-select">
                <form:options itemValue="id" itemLabel="pseudonym" items="${artists}"/>
            </form:select>
        </div>

        <div class="form-group" id="band-div">
            <label><i class="fas fa-users"></i> Band</label>
            <c:if test="${noauthor}">
                <br><span class="error">You must choose artist(s) or band</span>
            </c:if>
            <form:errors path="band" cssClass="error" element="div"/><br>
            <form:select path="band" class="multi-select-demo" id="band-select">
                <form:option value="0" label="None selected" id="band-first"/>
                <form:options itemValue="id" itemLabel="name" items="${bands}"/>
            </form:select>
        </div>
    </c:when>
    <c:otherwise>
        <div class="form-group" id="artist-div">
            <label><i class="fas fa-users"></i>Artists</label>
            <c:if test="${noauthor}">
                <br><span class="error">You must choose artist(s) or band</span>
            </c:if>
            <form:errors path="artists" cssClass="error" element="div"/><br>
            <form:select path="artists" multiple="true" class="multi-select-demo" id="artist-select">
                <form:options itemValue="id" itemLabel="pseudonym" items="${artists}"/>
            </form:select>
        </div>

        <div class="form-group" id="band-div" style="display:none">
            <label><i class="fas fa-users"></i>Band</label>
            <c:if test="${noauthor}">
                <br><span class="error">You must choose artist(s) or band</span>
            </c:if>
            <form:errors path="band" cssClass="error" element="div"/><br>
            <form:select path="band" class="multi-select-demo" id="band-select">
                <form:option value="0" label="None selected" id="band-first"/>
                <form:options itemValue="id" itemLabel="name" items="${bands}"/>
            </form:select>
        </div>
    </c:otherwise>

</c:choose>

<div class="form-group">
    <label><span class="glyphicon glyphicon-pencil"></span> Title</label><br>
    <form:errors path="title" cssClass="error" element="div"/>
    <form:input path="title"/>
</div>
<div class="form-group">
    <label><i class="fas fa-signature"></i></span> Label</label><br>
    <form:errors path="label" cssClass="error" element="div"/>
    <form:select path="label" class="multi-select-demo">
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
    <form:select path="format" items="${formats}" class="multi-select-demo"/>
</div>
<button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-cd"></span> Edit album</button>

<script type="text/javascript">

    $(document).ready(function() {
        $('.multi-select-demo').multiselect();
    });

</script>

<script type="text/javascript">
$("#guzik1").on("click", function(){

    if(!$(this).hasClass("active")){
        $(this).toggleClass("active");
        $("#guzik2").toggleClass("active");

        $("#band-div").hide();
        $("#artist-div").show();

        $('#band-select').val(0);
        $('#band-select').multiselect('refresh');
    }
})
</script>

<script type="text/javascript">
    $("#guzik2").on("click", function(){

        if(!$(this).hasClass("active")) {
            $(this).toggleClass("active");
            $("#guzik1").toggleClass("active");

            $("#artist-div").hide();
            $("#band-div").show();

            $("#artist-select").multiselect('deselectAll', false);
            $("#artist-select").multiselect('updateButtonText');
        }
    })
</script>

<script type="text/javascript">
    $(document).ready(function() {
        var modelvalue = '${backtoband}';
        if (modelvalue){
            $("#artist-div").hide();
            $("#band-div").show();
            $("#guzik1").toggleClass("active");
            $("#guzik2").toggleClass("active");
        }
    });
</script>
