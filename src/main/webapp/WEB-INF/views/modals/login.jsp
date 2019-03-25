<%--
<div class="container" id="login-container">
    <!-- Trigger the modal with a button -->

    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content" id="login-content">
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
                    <p>Forgot <a href="${pageContext.request.contextPath}/lostpassword">Password?</a></p>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(function() {

        $("#myModal").validate({
            rules: {
                login: {
                    required: true,
                    minlength: 8
                },
                action: "required"
            },
            messages: {
                pName: {
                    required: "Please enter some data",
                    minlength: "Your data must be at least 8 characters"
                },
                action: "Please provide some data"
            }
        });
    });
</script>
--%>
