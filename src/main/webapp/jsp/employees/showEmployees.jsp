<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    <%@include file='/css/bootstrap.css' %>
</style>
<html>
<head>
    <title>Employee list</title>
    <style>
        body {
            margin: auto;
        }

        .parent {
            margin: 20px;
            padding-right: 50%;
        }

        body {
            margin: auto;
        }

        .text {
            padding-left: 20px;
        }
    </style>
    <link type="text/css" href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet"/>
</head>
<body>
<form name="show employees" method="post">
    <input hidden value="${department.id}">

    <div class="text"><h2>Department: <c:out value="${department.name}"/></h2></div>
    <div class="parent">
        <table class="table table-striped">
            <thead>
            <tr>
                <td>User name</td>
                <td>User email</td>
                <td>Birthday</td>
                <td>Salary</td>
                <td colspan="2" align="center">Actions</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${employeeList}" var="employee">
                <tr>
                    <td><c:out value="${employee.name}"/></td>
                    <td><c:out value="${employee.email}"/></td>
                    <td><c:out value="${employee.date}"/></td>
                    <td><c:out value="${employee.salary}"/></td>
                    <td>
                        <button class="btn btn-default btn-sm" type="submit" name="action" value="editEmployee">Edit
                            <input type="hidden" name="id" value="<c:out value="${employee.id}"/>">
                        </button>
                    </td>
                    <td>
                        <button class="btn btn-default btn-sm" type="submit" name="action" value="deleteEmployee">Delete
                            <input type="hidden" name="id" value="<c:out value="${employee.id}"/>">
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</form>

<form name="Add new employee" method="post">
    <div class="text">
        <button class="btn btn-default" type="submit" name="action" value="showEmployeeForm">Add new employee
            <input type="hidden" name="id" value="${department.id}">
        </button>
    </div>
</form>
<div class="text">
    <form name="Back to department list" method="post">
        <button type="submit" class="btn btn-default" name="action" value="showDepartments">Back to department list
        </button>
    </form>
</div>
</body>
</html>