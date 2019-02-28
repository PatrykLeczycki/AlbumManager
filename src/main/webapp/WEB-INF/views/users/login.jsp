<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 24.02.19
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
    <link rel="stylesheet" href="/css/styles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style>
        .modal-header, h4, .close {
            background-color: #5cb85c;
            color:white !important;
            text-align: center;
            font-size: 30px;
        }
        .modal-footer {
            background-color: #f9f9f9;
        }

    </style>
</head>
<body>

<div class="container">
    <!-- Trigger the modal with a button -->

    <!-- Modal -->
    <div role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header" style="padding:35px 50px;">
                    <button type="button" class="close" data-dismiss="modal">x</button>
                    <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
                </div>
                <div class="modal-body" style="padding:40px 50px;">
                <form:form method="post" action="/loginpanel" modelAttribute="user">
                        <div class="form-group">
                            <label for="usrname"><span class="glyphicon glyphicon-user"></span> Login</label>
                            <form:input type="text" path="login" class="form-control" id="usrname" placeholder="Enter login"/>
                        </div>
                        <div class="form-group">
                            <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                            <form:input type="password" path="password" class="form-control" id="psw" placeholder="Enter password"/>
                        </div>

                        <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
                    </form:form>
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


<%--<table border="1" style="text-align: center" cellpadding = "10">

    <tbody>
    <form:form method="post" action="/login" modelAttribute="user">
        <table cellpadding = "10">

            <tr>
                <td>Login</td>
                <td>
                    <form:input path="login"/>
                </td>
                <td><form:errors path="login" cssClass="error" element="div"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><form:password path="password"/></td>
                <td><form:errors path="password" cssClass="error" element="div"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="add"></td>
            </tr>
        </table>
    </form:form>
    </tbody>
</table>--%>
</body>
</html>
