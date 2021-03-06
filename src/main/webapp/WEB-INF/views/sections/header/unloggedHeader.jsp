<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/" style="font-size: 30px">Album Manager</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/albums/all" style="font-size: 20px">Albums</a></li>
            <li><a href="${pageContext.request.contextPath}/artists/all" style="font-size: 20px">Artists</a></li>
            <li><a href="${pageContext.request.contextPath}/labels/all" style="font-size: 20px">Labels</a></li>
            <li><a href="${pageContext.request.contextPath}/bands/all" style="font-size: 20px">Bands</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <%--<li><a href="#myModalRegister" class="trigger-btn" data-toggle="modal" onclick="javascript: return false;" style="font-size: 20px"><span class="glyphicon glyphicon-pencil"></span> Sign Up</a></li>
            <li><a href="#myModal" class="trigger-btn" data-toggle="modal" name="login" onclick="javascript: return false;" style="font-size: 20px"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>--%>
                <li><a href="${pageContext.request.contextPath}/register" class="trigger-btn" style="font-size: 20px"><span class="glyphicon glyphicon-pencil"></span> Sign Up</a></li>
                <li><a href="${pageContext.request.contextPath}/login" class="trigger-btn" style="font-size: 20px"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>
