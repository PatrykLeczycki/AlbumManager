<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Album Manager</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/albums/all">Albums</a></li>
            <li><a href="/artists/all">Artists</a></li>
            <li><a href="/labels/all">Labels</a></li>
        </ul>
<%--todo: login i rejestracja nie działają poza index.jsp--%>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#myModalRegister" class="trigger-btn" data-toggle="modal" onclick="javascript: return false;" ><span class="glyphicon glyphicon-pencil"></span> Sign Up</a></li>
            <li><a href="#myModal" class="trigger-btn" data-toggle="modal" name="login" onclick="javascript: return false;" ><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>
