<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Departments</title>
    <meta charset="utf-8">
    <link type="text/css" href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="form-group">
        <form name="add" method="post" action="/addDepartment">
            <input type="hidden" name="id" value="<c:out value=""/>${department.id}">
            <label>Enter department name:</label>
            <font color="red" size="2"><c:out value="${errors.name}"/></font> <br>
            <div class="row">
                <div class="col-md-4">
                    <input type="text" class="form-control" name="name" placeholder="Input department name" value="${department.name}" width="500">
                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-default" name="action" value="addDepartment">Submit</button>
            <a class="btn btn-default" href="?action=backButton">Back to department list</a>
        </form>
    </div>
</div>
</body>
</html>
