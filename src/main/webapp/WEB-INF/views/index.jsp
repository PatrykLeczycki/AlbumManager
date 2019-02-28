<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<%--TODO: dać na głównej inny header jeśli użytkownik jest zalogowany--%>

<c:choose>
    <c:when test="${sessionScope.logged}">
        <%@include file="headerLogged.jsp"%>
    </c:when>
    <c:otherwise>
        <%@include file="header.jsp"%>
    </c:otherwise>
</c:choose>

<div class="container">
    <!-- Trigger the modal with a button -->

    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header" style="padding:35px 50px;">
                    <button type="button" class="close" data-dismiss="modal">x</button>
                    <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
                </div>
                <div class="modal-body" style="padding:40px 50px;">
                    <form role="form" method="post" action="/login">
                        <div class="form-group">
                            <label for="usrname"><span class="glyphicon glyphicon-user"></span> Login</label>
                            <input type="text" name="login" class="form-control" id="usrname" placeholder="Enter login">
                        </div>
                        <div class="form-group">
                            <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                            <input type="password" name="password" class="form-control" id="psw" placeholder="Enter password">
                        </div>

                        <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
                    <p>Not a member? <a href="#myModalRegister" data-toggle="modal" data-dismiss="modal">Sign up</a></p>
                    <p>Forgot <a href="/lostpassword">Password?</a></p>
                </div>
            </div>
        </div>
    </div>
</div>

<%----%>

<div class="container">
    <!-- Trigger the modal with a button -->
    <%--<button type="button" class="glyphicon glyphicon-log-in" id="myBtn">Login</button>--%>

    <!-- Modal -->
    <div class="modal fade" id="myModalRegister" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header" style="padding:35px 50px;">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4><span class="glyphicon glyphicon-pencil"></span> Register</h4>
                </div>
                <div class="modal-body" style="padding:40px 50px;">
                    <form role="form" action="/register" method="get">
                        <div class="form-group">
                            <label for="email"><span class="glyphicon glyphicon-envelope"></span> E-mail</label>
                            <input type="text" name="email" class="form-control" id="email" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <label for="login"><span class="glyphicon glyphicon-user"></span> Login</label>
                            <input type="text" class="form-control" name="login" id="login" placeholder="Enter login">
                        </div>
                        <div class="form-group">
                            <label for="psw1"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                            <input type="password" class="form-control" name="password1" id="psw1" placeholder="Enter password">
                        </div>
                        <div class="form-group">
                            <label for="psw2"><span class="glyphicon glyphicon-eye-open"></span> Confirm password</label>
                            <input type="password" class="form-control" name="password2" id="psw2" placeholder="Confirm password">
                        </div>
                        <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-pencil"></span> Register</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
                    <p>Already have an account? <a href="#myModal" data-toggle="modal" data-dismiss="modal">Sign in</a></p>
                </div>
            </div>

        </div>
    </div>
</div>

<script>
    jQuery(function(){
        if (location.hash.length > 0) {
            if (location.hash.endsWith("Modal")){
                if(sessionStorage.getItem("logged")){
                    jQuery('#myModal').click();
                }
            }
        }
    });
</script>

</body>
</html>