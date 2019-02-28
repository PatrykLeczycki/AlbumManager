<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Album Manager</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Albums
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/albums/all">All albums</a></li>
                    <li><a href="#">Your albums</a></li>
                    <li><a href="/albums/add">Add album</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Artists
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/artists/all">All artists</a></li>
                    <li><a href="/artists/add">Add artist</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Labels
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/labels/all">All labels</a></li>
                    <li><a href="/labels/add">Add label</a></li>
                </ul>
            </li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li><a href="/user/dashboard"><span>Dashboard</span></a></li>
            <ul class="dropdown-menu">
                <li><a href="/albums/all">All albums</a></li>
                <li><a href="#">Your albums</a></li>
                <li><a href="/albums/add">Add album</a></li>
            </ul>

            <%--TODO: spróbować dać settings tylko w dashboardzie--%>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Settings
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/user/newpassword">New password</a></li>
                </ul>
            </li>
            <li><a href="/logout" class="trigger-btn" data-toggle="modal" name="login"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>

<h1><</h1>