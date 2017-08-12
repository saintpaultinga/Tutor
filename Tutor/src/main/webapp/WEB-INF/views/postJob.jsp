<%--
  Created by IntelliJ IDEA.
  User: Zamuna
  Date: 8/11/2017
  Time: 11:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</head>
<body>
<%--Form start--%>
<div class="container">
    <div class="jumbotron">
        <form action="/jobPost/addPosition" method="post">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputTitle4" class="col-form-label">Title</label>
                    <input type="text" class="form-control" id="inputTitle4" placeholder="Title" name="">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputDescription4" class="col-form-label">Description</label>
                    <input type="text" class="form-control" name="description" id="inputDescription4" placeholder="Description">
                </div>
            </div>
            <div class="form-group">
                <label for="inputDuration" class="col-form-label">Duration</label>
                <input type="text" class="form-control" name="duration" id="inputDuration" placeholder="Duration">
            </div>
            <div class="form-group">
                <%--<label for="inputPosteddate" class="col-form-label">PostedDate</label>--%>
                <input type="hidden" class="form-control" name="posteddate" id="inputPosteddate" value="">
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEstimatedwage" class="col-form-label">Estimated Wage</label>
                    <input type="text" class="form-control" id="inputEstimatedwage" name="estimatedwage">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputCategory" class="col-form-label">Category</label>

                    <select id="inputCategory" name="category" class="form-control">
                        <c:forEach var="category" items="${categories}">
                        <option value="${category}">${category}</option>
                    </c:forEach>
                    </select>
                </div>
            </div>

            <button type="submit" class="btn btn-primary">Post Job</button>
        </form>
    </div>
</div>

<%--form end--%>
</body>
</html>
