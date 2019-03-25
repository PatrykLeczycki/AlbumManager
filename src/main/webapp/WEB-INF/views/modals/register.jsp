<%--
<div class="container" id="register-container">
    <!-- Modal -->
    <div class="modal fade" id="myModalRegister" role="dialog">
        <div class="modal-dialog" id="register-dialog">

            <!-- Modal content-->
            <div class="modal-content" id="register-content">
                <div class="modal-header" style="padding:35px 50px;">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4><span class="glyphicon glyphicon-pencil"></span> Register</h4>
                </div>
                <div class="modal-body" style="padding:40px 50px;">
                    <form role="form" action="/register">
                        <div class="form-group">
                            <label for="email"><span class="glyphicon glyphicon-envelope"></span> E-mail</label>
                            <c:if test="${sessionScope.emailpattern}">
                                <br><span class="error">Wrong e-mail format</span>
                            </c:if>
                            <c:if test="${sessionScope.emailexists}">
                                <br>E-mail address is already in use
                            </c:if>
                            <input type="text" name="email" class="form-control" id="email" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <label for="login"><span class="glyphicon glyphicon-user"></span> Login</label>
                            <h1>elo</h1>
                            <c:if test="${sessionScope.loginexists}">
                                <br>Login is already in use
                            </c:if>
                            <c:if test="${sessionScope.loginlength}">
                                <br>Login must have at least 5 characters
                            </c:if>
                            <input type="text" class="form-control" name="login" id="login" placeholder="Enter login">
                        </div>
                        <div class="form-group">
                            <label for="psw1"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
                            <c:if test="${sessionScope.passwordlength}">
                                <br>Password must have at least 8 characters
                            </c:if>
                            <input type="password" class="form-control" name="password1" id="psw1" placeholder="Enter password">
                        </div>
                        <div class="form-group">
                            <label for="psw2"><span class="glyphicon glyphicon-eye-open"></span> Confirm password</label>
                            <c:if test="${sessionScope.passwordsequal}">
                                <br>Passwords must be equal
                            </c:if>
                            <input type="password" class="form-control" name="password2" id="psw2" placeholder="Confirm password">
                        </div>
                        <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-pencil"></span> Register</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
                    <p>Already have an account? <a href="/login" data-toggle="modal" data-dismiss="modal">Sign in</a></p>
                </div>
            </div>

        </div>
    </div>
</div>--%>
