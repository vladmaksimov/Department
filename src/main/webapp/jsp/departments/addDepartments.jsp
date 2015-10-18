<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<style>--%>
    <%--<%@include file='/css/bootstrap.css' %>--%>
<%--</style>--%>
<html>
<head>
    <title>Departments</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <%--<link type="text/css" href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet"/>--%>
</head>
<body>
<div class="container">
    <div class="form-group">
        <form name="add" method="post">
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
        </form>
        <form name="Back to department list" method="get">
            <button type="submit" class="btn btn-default" name="action" value="backButton">Back to department list
            </button>
        </form>
    </div>
</div>
</body>
</html>
