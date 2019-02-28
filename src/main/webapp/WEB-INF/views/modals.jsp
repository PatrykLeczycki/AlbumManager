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
                    <form role="form" method="post" action="/loginpanel">
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