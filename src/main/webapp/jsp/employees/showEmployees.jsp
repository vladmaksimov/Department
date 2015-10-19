<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee list</title>
    <link type="text/css" href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <h2>Department: <c:out value="${department.name}"/></h2>
    <table class="table table-striped" style="width: 800px">
        <thead>
        <tr>
            <th>User name</th>
            <th>User email</th>
            <th>Birthday</th>
            <th>Salary</th>
            <th colspan="2" style="text-align: center">Actions</th>
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
                    <a class="btn btn-default btn-sm" href="?action=editEmployee&id=${employee.id}">Edit</a>
                </td>
                <td>
                    <a class="btn btn-default btn-sm" href="?action=deleteEmployee&id=${employee.id}&departmentId=${employee.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-default" href="?action=showEmployeeForm&id=${department.id}">Add new employee</a>
    <a class="btn btn-default" href="?action=backButton">Back</a>
</div>
</body>
</html>