<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/" style="font-size: 30px">Album Manager</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="font-size: 20px">Albums
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/albums/all" style="font-size: 20px">All albums</a></li>
                    <li><a href="${pageContext.request.contextPath}/user/albums" style="font-size: 20px">Your albums</a></li>
                    <li><a href="${pageContext.request.contextPath}/albums/add" style="font-size: 20px">Add album</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="font-size: 20px">Artists
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/artists/all" style="font-size: 20px">All artists</a></li>
                    <li><a href="${pageContext.request.contextPath}/artists/add" style="font-size: 20px">Add artist</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="font-size: 20px">Labels
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/labels/all" style="font-size: 20px">All labels</a></li>
                    <li><a href="${pageContext.request.contextPath}/labels/add" style="font-size: 20px">Add label</a></li>
                </ul>
            </li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <c:if test="${not empty dashboard}">
                <li><a href="${pageContext.request.contextPath}/user/dashboard" style="font-size: 20px"><span>Dashboard</span></a></li>
            </c:if>
            <%--TODO: spróbować dać settings tylko w dashboardzie--%>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="/#" style="font-size: 20px">Settings
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/user/newpassword" style="font-size: 20px">New password</a></li>
                </ul>
            </li>
            <li><a href="${pageContext.request.contextPath}/logout" class="trigger-btn" data-toggle="modal" name="login" style="font-size: 20px"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>