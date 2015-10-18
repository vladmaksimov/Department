<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<style>--%>
<%--<%@include file='/css/bootstrap.css' %>--%>
<%--</style>--%>
<html>
<head>
    <title>Employee list</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <%--<link type="text/css" href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet"/>--%>
</head>
<body>
<div class="container">

    <h2>Department: <c:out value="${department.name}"/></h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>User name</th>
            <th>User email</th>
            <th>Birthday</th>
            <th>Salary</th>
            <th colspan="2" align="center">Actions</th>
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
                    <form name="edit" action="edit" method="post">
                        <button class="btn btn-default btn-sm" type="submit" name="action" value="editEmployee">
                            Edit
                        </button>
                        <input type="hidden" name="id" value="<c:out value="${employee.id}"/>">
                    </form>
                </td>
                <td>
                    <form name="delete" method="post">
                        <button class="btn btn-default btn-sm" type="submit" name="action" value="deleteEmployee">Delete</button>
                        <input type="hidden" name="id" value="<c:out value="${employee.id}"/>">
                        <input type="hidden" name="departmentId" value="${department.id}">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form name="Add new employee" method="post">
        <button class="btn btn-default" type="submit" name="action" value="showEmployeeForm">Add new employee
        </button>
        <input type="hidden" name="id" value="${department.id}">
    </form>
    <br>
    <form name="Back to department list" method="get">
        <button type="submit" class="btn btn-default" name="action" value="backButton">Back to department list</button>
    </form>
</div>

</body>
</html>