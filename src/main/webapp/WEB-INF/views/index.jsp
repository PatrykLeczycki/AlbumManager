<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 22.02.19
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/styles.css">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Flat Modal Login Modal Form</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            font-family: 'Varela Round', sans-serif;
        }
        .modal-login {
            width: 350px;
        }
        .modal-login .modal-content {
            padding: 20px;
            border-radius: 5px;
            border: none;
        }
        .modal-login .modal-header {
            border-bottom: none;
            position: relative;
            justify-content: center;
        }
        .modal-login .close {
            position: absolute;
            top: -10px;
            right: -10px;
        }
        .modal-login h4 {
            color: #636363;
            text-align: center;
            font-size: 26px;
            margin-top: 0;
        }
        .modal-login .modal-content {
            color: #999;
            border-radius: 1px;
            margin-bottom: 15px;
            background: #fff;
            border: 1px solid #f3f3f3;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 25px;
        }
        .modal-login .form-group {
            margin-bottom: 20px;
        }
        .modal-login label {
            font-weight: normal;
            font-size: 13px;
        }
        .modal-login .form-control {
            min-height: 38px;
            padding-left: 5px;
            box-shadow: none !important;
            border-width: 0 0 1px 0;
            border-radius: 0;
        }
        .modal-login .form-control:focus {
            border-color: #ccc;
        }
        .modal-login .input-group-addon {
            max-width: 42px;
            text-align: center;
            background: none;
            border-width: 0 0 1px 0;
            padding-left: 5px;
            border-radius: 0;
        }
        .modal-login .btn {
            font-size: 16px;
            font-weight: bold;
            background: #19aa8d;
            border-radius: 3px;
            border: none;
            min-width: 140px;
            outline: none !important;
        }
        .modal-login .btn:hover, .modal-login .btn:focus {
            background: #179b81;
        }
        .modal-login .hint-text {
            text-align: center;
            padding-top: 5px;
            font-size: 13px;
        }
        .modal-login .modal-footer {
            color: #999;
            border-color: #dee4e7;
            text-align: center;
            margin: 0 -25px -25px;
            font-size: 13px;
            justify-content: center;
        }
        .modal-login a {
            color: #fff;
            text-decoration: underline;
        }
        .modal-login a:hover {
            text-decoration: none;
        }
        .modal-login a {
            color: #19aa8d;
            text-decoration: none;
        }
        .modal-login a:hover {
            text-decoration: underline;
        }
        .modal-login .fa {
            font-size: 21px;
        }
        .trigger-btn {
            display: inline-block;
            /*margin: 100px auto;*/
        }
    </style>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Album Manager</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <li><a href="#">Page 1</a></li>
            <li><a href="#">Page 2</a></li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Page 1-1</a></li>
                    <li><a href="#">Page 1-2</a></li>
                    <li><a href="#">Page 1-3</a></li>
                </ul>
            </li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li><a href="/register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <%--<li><a href="/login"><span class="glyphicon glyphicon-log-in" id="myBtn"></span> Login</a></li>--%>
            <li><a href="#myModal" class="trigger-btn" data-toggle="modal"><span class="glyphicon glyphicon-user"></span> Login</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <!-- Trigger the modal with a button -->
    <%--<button type="button" class="glyphicon glyphicon-log-in" id="myBtn">Login</button>--%>

    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header" style="padding:35px 50px;">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
                </div>
                <div class="modal-body" style="padding:40px 50px;">
                    <form role="form">
                        <div class="form-group">
                            <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
                            <input type="text" class="form-control" id="usrname" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                            <input type="text" class="form-control" id="psw" placeholder="Enter password">
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" value="" checked>Remember me</label>
                        </div>
                        <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
                    <p>Not a member? <a href="#">Sign Up</a></p>
                    <p>Forgot <a href="#">Password?</a></p>
                </div>
            </div>

        </div>
    </div>
</div>

<script>
    $(document).ready(function(){
        $("#myBtn").click(function(){
            $("#myModal").modal();
        });
    });
</script>



<%--<div class="main-div">
    <a href="/albums/all">All albums</a><br>
    <a href="/albums/add">Add album</a>
</div>


<div class="main-div">
    <a href="/artists/all">All artists</a>
    <a href="/artists/add">Add artist</a>
</div>

<div class="main-div">
    <a href="/labels/all">All labels</a>
    <a href="/labels/add">Add label</a>
</div>--%>

    <table class="outter-main-table" align="center" style="position: relative; /*vertical-align: 50%;*/ transform: translateY(75%)">
        <tbody>
        <tr>
            <td>
                <%--<div class="mainpage-div">--%>
                <table style="font-family: 'Times New Roman', Times, serif" class = "table" style="text-align: center" cellpadding = "20">
                    <thead>
                    <th style="font-size: 20px;">Albums</th>
                    </thead>
                    <tbody>
                    <tr><td><a href="/albums/all"><button>All albums</button></a></td></tr>
                    <tr><td><a href="/albums/add"><button>Add album</button></a></td></tr>
                    </tbody>
                </table>
                <%--</div>--%>
            </td>
            <%--<div class="mainpage-div">--%>
            <td>
                <table class = "table" style="text-align: center" cellpadding = "20">
                    <thead>
                    <th style="font-size: 20px">Artists</th>
                    </thead>
                    <tbody>
                    <tr><td><a href="/artists/all"><button>All artists</button></a></td></tr>
                    <tr><td><a href="/artists/add"><button>Add artist</button></a></td></tr>
                    </tbody>

                </table>
            </td>
            <%--</div>--%>

            <%--<div class="mainpage-div">--%>
            <td>
                <table class = "table" cellpadding = "20">
                    <thead>
                    <th style="font-size: 20px">Labels</th>
                    </thead>
                    <tbody>
                    <tr><td><a href="/labels/all"><button>All labels</button></a></td></tr>
                    <tr><td><a href="/labels/add"><button>Add label</button></a></td></tr>
                    </tbody>

                </table>
                <%--</div>--%>

                <%--<div class="mainpage-div">--%>
                <%--</div>--%>
            </td>
        </tr>

        <% if (session.getAttribute("logged") == null) { %>
        <tr>
            <td></td>
            <td>
                <table class = "table" style="text-align: center" cellpadding = "20">
                    <thead>
                    <th style="font-size: 20px;">Dashboard</th>
                    </thead>
                    <tbody>
                    <tr><td><a href="/login" class="button">Log in</a></td></tr>
                    </tbody>

                </table>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>

</body>
</html>