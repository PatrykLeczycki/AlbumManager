<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 01.03.19
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="files.jsp"%>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.13.5/dist/bootstrap-table.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://unpkg.com/bootstrap-table@1.13.5/dist/bootstrap-table.min.js"></script>
    <!-- Latest compiled and minified Locales -->
    <script src="https://unpkg.com/bootstrap-table@1.13.5/dist/locale/bootstrap-table-zh-CN.min.js"></script>

    <script
            src="https://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container body-content">
    <div class="page-header">
        <label class="heading">History</label>
        <div class="form-group">
            <fieldset>
                <form action="" class="form-group" method="post">
                    <div class="table-responsive">
                        <div class="table-responsive">

                            <table id="escalation" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                <thead>
                                <tr>
                                    <th>Application</th>
                                    <th>EMOPOP</th>
                                    <th>Stats</th>
                                    <th>Statement</th>
                                    <th>Time</th>
                                    <th>Updated</th>
                                    <th>Details</th>
                                    <th>Price</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>Tiger Nixon</td>
                                    <td>System Architect</td>
                                    <td>Edinburgh</td>
                                    <td>61</td>
                                    <td>2011/04/25</td>
                                    <td>$320,800</td>
                                    <td>2011/04/25</td>
                                    <td>$320,800</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </form>            <!--END OF FORM ^^-->
            </fieldset>
        </div>
        <hr />
    </div>
</div>

<script>
    $(document).ready(function () {
        $('#escalation').DataTable();
    });
</script>
</body>
</html>
