<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/css/bootstrap.css' %>
</style>
<html>
<head>
    <title></title>
    <link type="text/css" href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet"/>
    <style>
        body {
            margin: auto;
        }

        .parent {
            margin: 20px;
            padding-right: 70%;
        }

        body {
            margin: auto;
        }

        .text {
            padding-left: 20px;
        }
    </style>
</head>
<body>
<form name="Add of edit Departments" method="post">
    <div class="parent">
        <div class="form-group">
            <input type="hidden" name="id" value="<c:out value=""/>${department.id}">
            <label>Enter department name:</label>
            <font color="red" size="2">
                <c:out value="${errors.name}"/>
            </font> <br>
            <input type="text" class="form-control" name="name" placeholder="Input department name"
                   value="${department.name}">
        </div>
    </div>

    <button type="submit" class="btn btn-default" name="action" value="addDepartment">Submit</button>
</form>
<br>

<form name="Back to department list" method="post">
    <button type="submit" class="btn btn-default" name="action" value="showDepartments">Back to department list</button>
</form>
</body>
</html>
